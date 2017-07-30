package de.thm.smarthome.main.manager.controller.eventmanager;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import openllet.owlapi.OpenlletReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.File;
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
    private String ontologyName                 = "SmartHomeOntology.owl";
    private String owlAPIVersion                = "5.1.0";
    private String reasonerVersion              = "2.6.1";

    private EventManager()
    {
        initOWLAPI();
        doFancyStuff();
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
        OWLReasonerFactory reasonerFactory = new OpenlletReasonerFactory();
        ontologyManager = OWLManager.createOWLOntologyManager();
        File ontologyFile = new File("src/de/thm/smarthome/main/manager/controller/eventmanager/resources/" + ontologyName);

        SmartHomeLogger.log("Using OWL API (" + owlAPIVersion + ")");

        try
        {
            ontology = ontologyManager.loadOntologyFromOntologyDocument(ontologyFile);
            SmartHomeLogger.log("Ontology " + ontologyName + " loaded successfully");

            reasoner = reasonerFactory.createReasoner(ontology);
            SmartHomeLogger.log("Using reasoner " + reasonerFactory.getReasonerName() + " (" + reasonerVersion + ")");
        }
        catch (OWLOntologyCreationException e)
        {
            SmartHomeLogger.log(e);
            return;
        }
    }

    private void doFancyStuff(){
        Stream<OWLClass> owlClassStream = ontology.classesInSignature();
        List<OWLClass> owlClassList = owlClassStream.collect(Collectors.toList());

        for (OWLClass owlClass : owlClassList)
        {
            //SmartHomeLogger.log(owlClass.toString());
           // owlClass
        }
    }

    private void doReasoning(){

    }
}
