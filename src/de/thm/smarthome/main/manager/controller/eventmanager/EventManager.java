package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.IObserver;
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
public class EventManager implements IEventManager, IObserver {
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
    }

    public static EventManager getInstance() {
        return ourInstance;
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("EventManager: Detected a change! [" + o.toString() + "]");

        /*if(MetaDataManager.useOntology)
            doReasoning();*/
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
        //createHeatingIndividualIfNotPresent(); //TODO: just for testing!
        applyPowerStateToIndividual(heatingIndividual, smartHeating.getPowerState().getPowerState_Enum());
        applyTemperatureToIndividual(heatingIndividual, smartHeating.getCurrentTemperature().getMeasure_Double());
        applyActionModeToIndividual(heatingIndividual, smartHeating.getActionMode().getActionMode_Enum());
    }

    private void createHeatingIndividualIfNotPresent(){ //TODO: GO ON HERE, check this
        // Get entity class
        OWLClass owlClass = dataFactory.getOWLClass(heatingIRI);

        // Create individual
        OWLNamedIndividual namedIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, heatingName));

        // Create axiom
        OWLClassAssertionAxiom classAssertionAxiom = dataFactory.getOWLClassAssertionAxiom(owlClass, namedIndividual);

        // Apply axiom to ontology
        ontologyManager.addAxiom(ontology, classAssertionAxiom);
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
        //heatingName = smartHeating.getGenericName().replace(" ", "");
        heatingName = "MyHeating"; //TODO: just for testing
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
            List<OWLNamedIndividual> namedIndividualList = reasoner.objectPropertyValues(namedIndividual, objectProperty).collect(Collectors.toList());
            return namedIndividualList.get(namedIndividualList.size() - 1);
        }
        catch (Exception e){
            return null;
        }
    }

    private OWLLiteral readDataPropertyFromOntology(OWLNamedIndividual namedIndividual, OWLDataProperty dataProperty){
        try {
            List<OWLLiteral> literalList = reasoner.dataPropertyValues(namedIndividual, dataProperty).collect(Collectors.toList());
            return literalList.get(literalList.size() - 1);
        }
        catch (Exception e){
            return null;
        }
    }

    private void invokeActionsAtHeating(HeatingTransferObject heatingTransferObject){
        double currentValueTemperature = smartHeating.getDesiredTemperature().getMeasure_Double();
        double inferredValueTemperature = heatingTransferObject.getDesiredTemperature().getMeasure_Double();

        EActionMode currentValueActionMode = smartHeating.getActionMode().getActionMode_Enum();
        EActionMode inferredValueActionMode = heatingTransferObject.getActionMode().getActionMode_Enum();

        EPowerState currentValuePowerState = smartHeating.getPowerState().getPowerState_Enum();
        EPowerState inferredValuePowerState = heatingTransferObject.getPowerState().getPowerState_Enum();

        if(currentValueTemperature != inferredValueTemperature) {
            smartHeating.setTemperature(heatingTransferObject.getDesiredTemperature());
            SmartHomeLogger.log("EventManager: Inferred new value: " + inferredValueTemperature + " Old value: " + currentValueTemperature + " (Heating temperature)");
        }

        if(currentValueActionMode != inferredValueActionMode) {
            smartHeating.setActionMode(heatingTransferObject.getActionMode());
            SmartHomeLogger.log("EventManager: Inferred new value: " + inferredValueActionMode + " Old value: " + currentValueActionMode + " (Heating actionMode)");
        }

        if(currentValuePowerState != inferredValuePowerState) {
            smartHeating.setPowerState(heatingTransferObject.getPowerState());
            SmartHomeLogger.log("EventManager: Inferred new value: " + inferredValuePowerState + " Old value: " + currentValuePowerState + " (Heating powerState)");
        }
    }

    private void doReasoning(){
        try {
            // Apply (current) values to ontology
            applyHeatingPropertiesToOntology();
            //applyShutterPropertiesToOntology();
            //applyThermometerPropertiesToOntology();
            //applyWeatherStationPropertiesToOntology();

            // Read inferred (new) values and invoke action
            invokeActionsAtHeating(readInferredHeatingProperties());
        }
        catch (Exception e){
            //SmartHomeLogger.log(e);
        }
    }
}
