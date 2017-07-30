package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
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
import java.util.stream.Stream;

/**
 * Created by Nils on 05.02.2017.
 */
public class EventManager implements IEventManager {
    private static EventManager ourInstance     = new EventManager();
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

    private EventManager()
    {
        initOWLAPI();
        doFancyStuff(); //TODO: just for testing!
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

    private void saveOntology(){

    }

    private void createIRIs(){
        heatingIRI          = IRI.create(ontologyNamespace,"Heating");
        shutterIRI          = IRI.create(ontologyNamespace,"Shutter");
        weatherStationIRI   = IRI.create(ontologyNamespace,"WeatherStation");
        thermometerIRI      = IRI.create(ontologyNamespace,"Thermometer");
    }

    private void logClassAxioms(OWLClass owlClass){
        Stream<OWLClassAxiom> classAxiomStream = ontology.axioms(owlClass);
        List<OWLClassAxiom> classAxiomList = classAxiomStream.collect(Collectors.toList());

        for(OWLClassAxiom classAxiom : classAxiomList)
        {
            SmartHomeLogger.log(classAxiom.toString());
        }
    }

    private void logNamedIndividuals(){
        Stream<OWLNamedIndividual> individualStream = ontology.individualsInSignature();
        List<OWLNamedIndividual> individualList = individualStream.collect(Collectors.toList());

        for(OWLNamedIndividual namedIndividual : individualList)
        {
            SmartHomeLogger.log(namedIndividual.toString().replace("<","").replace(">",""));
        }
    }

    private void logDataPropertyAssertionAxioms(OWLNamedIndividual namedIndividual){
        Stream<OWLDataPropertyAssertionAxiom> dataPropertyAssertionAxiomStream = ontology.dataPropertyAssertionAxioms(namedIndividual);
        List<OWLDataPropertyAssertionAxiom> dataPropertyAssertionAxiomList = dataPropertyAssertionAxiomStream.collect(Collectors.toList());

        for (OWLDataPropertyAssertionAxiom ax: dataPropertyAssertionAxiomList) {
            SmartHomeLogger.log((ax.getProperty().toString() + " : " + ax.getObject().getDatatype().toString() + " " + ax.getObject().parseDouble()).replace("<","").replace(">",""));
        }
    }

    private void logObjectPropertyAssertionAxioms(OWLNamedIndividual namedIndividual){
        Stream<OWLObjectPropertyAssertionAxiom> objectPropertyAssertionAxiomStream = ontology.objectPropertyAssertionAxioms(namedIndividual);
        List<OWLObjectPropertyAssertionAxiom> objectPropertyAssertionAxiomList = objectPropertyAssertionAxiomStream.collect(Collectors.toList());

        for (OWLObjectPropertyAssertionAxiom ax: objectPropertyAssertionAxiomList) {
            SmartHomeLogger.log((ax.getProperty().toString() + " : " + ax.getObject().toString()).replace("<","").replace(">",""));
        }
    }

    private void logObjectProprtyAssertionAxioms(OWLNamedIndividual namedIndividual){

    }

    private void doFancyStuff(){
        String heatingName = "MyHeating";

        //SmartHomeLogger.log("Reasoner consistency check: " + reasoner.isConsistent());


        OWLNamedIndividual heatingIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, heatingName));
        OWLNamedIndividual powerStateIndividual = dataFactory.getOWLNamedIndividual(IRI.create(ontologyNamespace, "_ON"));

        OWLObjectProperty hasPowerState = dataFactory.getOWLObjectProperty(IRI.create(ontologyNamespace,"hasPowerState"));
        OWLDataProperty hasTemperature = dataFactory.getOWLDataProperty(IRI.create(ontologyNamespace,"hasTemperature"));


        // Create object property for PowerState
        // Property:        hasPowerState
        // Individual:      MyHeating
        // Value:           _ON
        OWLObjectPropertyAssertionAxiom objectPropertyAssertionAxiom = dataFactory.getOWLObjectPropertyAssertionAxiom(hasPowerState,heatingIndividual,powerStateIndividual);

        // Remove existing axioms of same type and domain
        List<OWLObjectPropertyAssertionAxiom> axiomsToRemove = new ArrayList<>();
        axiomsToRemove.add(objectPropertyAssertionAxiom);
        ontologyManager.removeAxioms(ontology,axiomsToRemove.stream()); //TODO: Removing axioms does not seem to work..

        // Create axiom
        AddAxiom addAxiom = new AddAxiom(ontology,objectPropertyAssertionAxiom);

        // Apply this change to ontology
        ontologyManager.applyChange(addAxiom);


        // Create data property for Temperature
        // Property:        hasTemperature
        // Individual:      MyHeating
        // Value:           20.0
        OWLDataPropertyAssertionAxiom dataPropertyAssertionAxiom = dataFactory.getOWLDataPropertyAssertionAxiom(hasTemperature,heatingIndividual,20.0);

        // Remove existing axioms of same type and domain
        List<OWLDataPropertyAssertionAxiom> dpAxiomsToRemove = new ArrayList<>();
        dpAxiomsToRemove.add(dataPropertyAssertionAxiom);
        ontologyManager.removeAxioms(ontology,dpAxiomsToRemove.stream()); //TODO: Removing axioms does not seem to work..

        // Create axiom
        addAxiom = new AddAxiom(ontology,dataPropertyAssertionAxiom);

        // Apply this change to ontology
        ontologyManager.applyChange(addAxiom);


        // Use reasoner to read inferred properties caused by SWRL rules etc.
        Stream<OWLNamedIndividual> namedIndividualStream = reasoner.objectPropertyValues(heatingIndividual, hasPowerState);
        Stream<OWLLiteral> literalStream = reasoner.dataPropertyValues(heatingIndividual, hasTemperature);

        // Convert streams to lists
        List<OWLNamedIndividual> namedIndividualList = namedIndividualStream.collect(Collectors.toList());
        List<OWLLiteral> literalList = literalStream.collect(Collectors.toList());

        //SmartHomeLogger.log("ObjectProperties:");

        for (OWLNamedIndividual namedIndividual : namedIndividualList)
        {
            //SmartHomeLogger.log(namedIndividual.toString());
        }

        //SmartHomeLogger.log("DataProperties:");

        for (OWLLiteral literal : literalList)
        {
            //SmartHomeLogger.log(literal.toString());
        }

/*
        try
        {


            if(namedIndividualList.get(1).toString().replace("<","").replace(">","").replace(ontologyNamespace,"").equals("_ON"))
                SmartHomeLogger.log("It´s ON!");
            else
                SmartHomeLogger.log("It´s OFF!");
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }

*/






















    }

    private void doReasoning(){

    }
}
