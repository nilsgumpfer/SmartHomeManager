package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import openllet.owlapi.OpenlletReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nils on 05.02.2017.
 */
public class EventManager implements IEventManager {
    private static EventManager ourInstance     = new EventManager();
    private DeviceManager deviceManager         = DeviceManager.getInstance();
    private OWLOntology ontology                = null;
    private OWLReasoner reasoner                = null;
    private OWLOntologyManager ontologyManager  = null;
    private OWLDataFactory dataFactory          = null;
    private PrefixManager prefixManager         = null;
    private String ontologyName                 = "SmartHomeOntology.owl";
    private String owlAPIVersion                = "5.1.0";
    private String reasonerVersion              = "2.6.1";
    private String ontologyNamespace            = "http://www.thm.de/eva/ontologies/smarthome#";
    private IRI heatingIRI                      = null;
    private IRI shutterIRI                      = null;
    private IRI weatherStationIRI               = null;
    private IRI thermometerIRI                  = null;
    private File ontologyFile                   = null;
    private OWLReasonerFactory reasonerFactory  = null;
    private OWLObjectProperty hasPowerState     = null;
    private OWLObjectProperty hasActionMode     = null;
    private OWLDataProperty hasTemperature      = null;
    private OWLDataProperty hasWindVelocity     = null;
    private OWLDataProperty hasRainfallAmount   = null;
    private OWLDataProperty hasAirPressure      = null;
    private OWLDataProperty hasAirHumidity      = null;
    private SmartHeating smartHeating                       = null;
    private SmartThermometer smartThermometer               = null;
    private SmartWeatherStation smartWeatherStation         = null;
    private String heatingName                              = null;
    private String thermometerName                          = null;
    private String weatherStationName                       = null;
    private OWLNamedIndividual heatingIndividual            = null;
    private OWLNamedIndividual thermometerIndividual        = null;
    private OWLNamedIndividual weatherStationIndividual     = null;


    private EventManager()
    {
        initOWLAPI();
        //doFancyStuff(); //TODO: just for testing!
    }

    public static EventManager getInstance() {
        return ourInstance;
    }

    @Override
    public void update(AObservable o, Object change) {
        SmartHomeLogger.log("EventManager: Detected a change! [" + o.toString() + "]");
        doReasoning();
    }

    private void initOWLAPI()
    {
        SmartHomeLogger.log("Using OWL API (" + owlAPIVersion + ")");

        initializeObjects();
        createIRIs();
        initializeProperties();
        loadOntology();
        createReasoner();
    }

    private void initializeObjects(){
        reasonerFactory     = new OpenlletReasonerFactory();
        ontologyManager     = OWLManager.createOWLOntologyManager();
        dataFactory         = ontologyManager.getOWLDataFactory();
        prefixManager       = new DefaultPrefixManager(null, null,ontologyNamespace);
        ontologyFile        = new File("src/de/thm/smarthome/main/manager/controller/eventmanager/resources/" + ontologyName);
    }

    private void initializeProperties(){
        hasPowerState       = dataFactory.getOWLObjectProperty(IRI.create(ontologyNamespace,"hasPowerState"));
        hasActionMode       = dataFactory.getOWLObjectProperty(IRI.create(ontologyNamespace,"hasActionMode"));
        hasTemperature      = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasTemperature"));
        hasWindVelocity     = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasWindVelocity"));
        hasRainfallAmount   = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasRainfallAmount"));
        hasAirHumidity      = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasAirHumidity"));
        hasAirPressure      = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasAirPressure"));
    }

    private void loadOntology(){
        try
        {
            ontology = ontologyManager.loadOntologyFromOntologyDocument(ontologyFile);
            SmartHomeLogger.log("Ontology " + ontologyName + " loaded successfully");
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
    }

    private void createReasoner() {
        reasoner = reasonerFactory.createNonBufferingReasoner(ontology);
        SmartHomeLogger.log("Using reasoner " + reasonerFactory.getReasonerName() + " (" + reasonerVersion + ")");
    }

    private void createIRIs(){
        heatingIRI          = IRI.create(ontologyNamespace,"Heating");
        shutterIRI          = IRI.create(ontologyNamespace,"Shutter");
        weatherStationIRI   = IRI.create(ontologyNamespace,"WeatherStation");
        thermometerIRI      = IRI.create(ontologyNamespace,"Thermometer");
    }

    private void applyTemperatureToIndividual(OWLNamedIndividual namedIndividual, double temperature)
    {
        applyDoubleToIndividual(namedIndividual, hasTemperature, temperature);
    }

    private void applyWindVelocityToIndividual(OWLNamedIndividual namedIndividual, double temperature)
    {
        applyDoubleToIndividual(namedIndividual, hasWindVelocity, temperature);
    }

    private void applyRainfallAmountToIndividual(OWLNamedIndividual namedIndividual, double temperature)
    {
        applyDoubleToIndividual(namedIndividual, hasRainfallAmount, temperature);
    }

    private void applyAirPressureToIndividual(OWLNamedIndividual namedIndividual, double temperature)
    {
        applyDoubleToIndividual(namedIndividual, hasAirPressure, temperature);
    }

    private void applyAirHumidityToIndividual(OWLNamedIndividual namedIndividual, double temperature)
    {
        applyDoubleToIndividual(namedIndividual, hasAirHumidity, temperature);
    }

    private void applyDoubleToIndividual(OWLNamedIndividual namedIndividual, OWLDataProperty property, double value)
    {
        // Create data property axiom
        OWLDataPropertyAssertionAxiom dataPropertyAssertionAxiom = dataFactory.getOWLDataPropertyAssertionAxiom(property, namedIndividual, value);

        // Clean existing axioms to avoid duplicates
        cleanPropertyAxiomsForIndividual(namedIndividual, property);

        // Apply changed / new axiom to ontology
        ontologyManager.addAxiom(ontology, dataPropertyAssertionAxiom);
    }

    private void applyPowerStateToIndividual(OWLNamedIndividual namedIndividual, EPowerState ePowerState)
    {
        applyStringToIndividual(namedIndividual, hasPowerState, "_" + ePowerState.toString());
    }

    private void applyActionModeToIndividual(OWLNamedIndividual namedIndividual, EActionMode eActionMode)
    {
        applyStringToIndividual(namedIndividual, hasActionMode, "_" + eActionMode.toString());
    }

    private void applyStringToIndividual(OWLNamedIndividual namedIndividual, OWLObjectProperty objectProperty , String string)
    {
        // Create property-object
        OWLNamedIndividual propertyIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, string));

        // Clean existing axioms to avoid duplicates
        cleanPropertyAxiomsForIndividual(namedIndividual, objectProperty);

        // Create object property axiom for powerState
        OWLObjectPropertyAssertionAxiom objectPropertyAssertionAxiom = dataFactory.getOWLObjectPropertyAssertionAxiom(objectProperty, namedIndividual, propertyIndividual);

        // Apply changed / new axiom to ontology
        ontologyManager.addAxiom(ontology, objectPropertyAssertionAxiom);
    }

    private void cleanPropertyAxiomsForIndividual(OWLNamedIndividual namedIndividual, OWLProperty property){
        List<OWLAxiom> axiomList = ontology.axioms(namedIndividual).collect(Collectors.toList());
        List<OWLAxiom> axiomsToRemove = new ArrayList<>();

        for(OWLAxiom axiom : axiomList)
        {
            List<OWLProperty>   propertyList = axiom.dataPropertiesInSignature().collect(Collectors.toList());
                                propertyList .addAll(axiom.objectPropertiesInSignature().collect(Collectors.toList()));

            for(OWLProperty currentProperty : propertyList)
            {
                if(currentProperty.getIRI().equals(property.getIRI())) {
                    axiomsToRemove.add(axiom);
                }
            }
        }

        ontologyManager.removeAxioms(ontology, axiomsToRemove.stream());
    }

    private void applyHeatingPropertiesToOntology(){
        updateHeatingObjects();
        applyPowerStateToIndividual(heatingIndividual, smartHeating.getPowerState().getPowerState_Enum());
        applyTemperatureToIndividual(heatingIndividual, smartHeating.getCurrentTemperature().getMeasure_Double());
        applyActionModeToIndividual(heatingIndividual, smartHeating.getActionMode().getActionMode_Enum());
    }

    private void applyShutterPropertiesToOntology(){
        /*updateShutterObjects();*/
    }

    private void applyThermometerPropertiesToOntology(){
        updateThermometerObjects();
        applyTemperatureToIndividual(thermometerIndividual, smartThermometer.getTemperature().getMeasure_Double());
        applyActionModeToIndividual(thermometerIndividual, smartThermometer.getActionMode().getActionMode_Enum());
    }

    private void applyWeatherStationPropertiesToOntology(){
        updateWeatherStationObjects();
        applyActionModeToIndividual(weatherStationIndividual, smartWeatherStation.getActionMode().getActionMode_Enum());
        applyRainfallAmountToIndividual(weatherStationIndividual, smartWeatherStation.getRainfallAmount().getMeasure_Double());
        applyWindVelocityToIndividual(weatherStationIndividual, smartWeatherStation.getWindVelocity().getMeasure_Double());
        applyAirHumidityToIndividual(weatherStationIndividual, smartWeatherStation.getAirHumidity().getMeasure_Double());
        applyAirPressureToIndividual(weatherStationIndividual, smartWeatherStation.getAirPressure().getMeasure_Double());
    }

    private void updateThermometerObjects(){
        smartThermometer = deviceManager.getSmartThermometer();
        thermometerName = smartThermometer.getGenericName().replace(" ", "");
        thermometerIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, thermometerName));
    }

    private void updateWeatherStationObjects(){
        smartWeatherStation = deviceManager.getSmartWeatherStation();
        weatherStationName = smartWeatherStation.getGenericName().replace(" ", "");
        weatherStationIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, weatherStationName));
    }

    private void updateHeatingObjects(){
        smartHeating = deviceManager.getSmartHeating();
        heatingName = smartHeating.getGenericName().replace(" ", "");
        heatingIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, heatingName));
    }

    private HeatingTransferObject readInferredHeatingProperties(){
        updateHeatingObjects();

        HeatingTransferObject heatingTransferObject = smartHeating.getHeatingData();

        // Read object properties
        OWLNamedIndividual actionMode       = readObjectPropertyFromOntology(heatingIndividual, hasActionMode);
        OWLNamedIndividual powerState       = readObjectPropertyFromOntology(heatingIndividual, hasPowerState);

        // Read data properties
        OWLLiteral temperature              = readDataPropertyFromOntology(heatingIndividual, hasTemperature);

        // Convert object properties
        ActionModeBean actionModeBean       = getActionModeBean(actionMode);
        PowerStateBean powerStateBean       = getPowerStateBean(powerState);

        // Convert data properties
        double dTemperature                 = getDouble(temperature);


        // Update values in transfer object
        heatingTransferObject.setActionMode(actionModeBean);
        heatingTransferObject.setPowerState(powerStateBean);
        heatingTransferObject.setDesiredTemperature(new MeasureBean(dTemperature, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));

        return heatingTransferObject;
    }

    /*private ThermometerTransferObject readInferredThermometerProperties(){
        //TODO: Merken! ..das macht natürlich keinen Sinn, weil an den eingesetzten Sensoren nichts geändert werden kann! (lediglich an Rolläden und der Heizung)
    }*/

    private double getDouble(OWLLiteral literal){
        return literal.parseDouble();
    }

    private ActionModeBean getActionModeBean(OWLNamedIndividual individual){
        return new ActionModeBean(individual.getIRI().getRemainder().get().replace("_",""));
    }

    private PowerStateBean getPowerStateBean(OWLNamedIndividual individual){
        return new PowerStateBean(individual.getIRI().getRemainder().get().replace("_",""));
    }

    private OWLNamedIndividual readObjectPropertyFromOntology(OWLNamedIndividual namedIndividual, OWLObjectProperty objectProperty){
        try {
            return reasoner.objectPropertyValues(namedIndividual, objectProperty).collect(Collectors.toList()).get(0);
        }
        catch (Exception e){
            return null;
        }
    }

    private OWLLiteral readDataPropertyFromOntology(OWLNamedIndividual namedIndividual, OWLDataProperty dataProperty){
        try {
            return reasoner.dataPropertyValues(namedIndividual, dataProperty).collect(Collectors.toList()).get(0);
        }
        catch (Exception e){
            return null;
        }
    }

    private void doFancyStuff(){

        // Apply (current) values to ontology
        applyHeatingPropertiesToOntology();
        applyShutterPropertiesToOntology();
        applyThermometerPropertiesToOntology();
        applyWeatherStationPropertiesToOntology();

        // Read inferred (new) values
        readInferredHeatingProperties();

        /*

        SmartHomeLogger.log("ObjectProperties:");
        for (OWLNamedIndividual namedIndividual : namedIndividualList)
        {
            SmartHomeLogger.log(namedIndividual.toString());
            //TODO: Go on here. Sort individuals by IRI, assign actions according to property (e.g. switch on/off heating)
            //TODO: nicht pro device irgendwelche inferred individuals durchgehen, sondern für alle gemeinsam(macht ja auch sinn! :) )
            //TODO: übertragung der derzeitigen werte der verbundenen geräte via schleife(je nachdem was vorhanden ist, gerade bzgl. shutter schleife wichtig)
            //TODO: geräte werden auf basis ihres generic name angelegt
            //TODO: zuerst alle attribute der geräte in ontologie übertragen, anschließend reasoner anwerfen, individuals sammeln und entsprechende aktionen durchführen (dispatcher zur zuteilung verwenden, etc.)
        }

        List<OWLLiteral> literalList = reasoner.dataPropertyValues(heatingIndividual, hasTemperature).collect(Collectors.toList());

        SmartHomeLogger.log("DataProperties:");
        for (OWLLiteral literal : literalList)
        {
            SmartHomeLogger.log(literal.toString());
        }
        */

    }

    private void doReasoning(){

    }
}
