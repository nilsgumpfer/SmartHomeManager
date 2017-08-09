package de.buderus.driver.heating;

                        //Der Treiber ist das Bindeglied zum Gerät. Über die Schnittstellen werden
                        // die definierten Methoden usw. dem Treiber zu Verfügung gestellt.
import HeizungServer.interfaces.HeizungClientInterface;
import HeizungServer.interfaces.HeizungServerInterface;

                        //Beans werden durchgereicht, die befüllt sind mit Informationen
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.Naming; // Namensdienst; mit disem kann über ein Verweis wird das Server-Objekt abgerufbar
import java.rmi.Remote; //Definition entfernter Methoden
import java.rmi.RemoteException; //Deklarierte Methode müssen RemoteException werfen
import java.rmi.registry.LocateRegistry; //Trägerprozess für ein Register öffentlicher Objekte (Verwaltung: nur systemlokale Objekte)
import java.rmi.server.UnicastRemoteObject; //Objekt wird fernaufrufbar (ansonsten wäre statischer Export erforderlich)


/**
 * Created  on 27.01.2017.
 */


        //Die die Daten bereitstellende Klasse, wird erweitert um die Klasse Observable.
        //ClientInterface, sodass die Info vorliegt, von welchem Client die Anfrage kommt

public class BuderusHeatingDriver extends AObservable implements HeizungClientInterface, IObserver
{
    private HeizungServerInterface deviceServer;

    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;
    private String hostname;

    //Übergabe damit der Treiber weiß mit welcher Heizung er sich verbinden muss
    public BuderusHeatingDriver(String serialnumber, String genericName, ModelVariantBean modelVariantBean)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;
        this.modelVariant   = modelVariantBean; //dient zur Ermittlung der Variante

        readModelVariantInformation();

        initConnection(); //bei Erstellung des Treiber Verbindung herstellen
    }

                //über switch-case Ermittlung des Heizungs-Modells und einholen der Information
                //anhand der Modelvariante weiß Treiber, wie der Hostname gesetzt werden muss
       private void readModelVariantInformation() {
        switch (modelVariant.getModelVariant_Enum()){
            case HEATING_3000:
                    hostname = modelVariant.getModelVariant_String();
                    break;
            case HEATING_2000:
                hostname = modelVariant.getModelVariant_String();
                break;
            case HEATING_1000:
                hostname = modelVariant.getModelVariant_String();
                break;
            }

    }

    private void initConnection()
    {


        int port    = 0; //das System bestimmt selbst den Port über die die Verbindung läuft

        try {
                     //SmartHomeLooger: Statusrückgabe
            SmartHomeLogger.log("Looking for Buderus heating: " + modelVariant + "..");

                     //Kontrolle: Läuft unter hostnahme und dem port eine bestimmte Registry
            // liefert Fernaufruf eines (lokalen oder entfernten) Registry-Objekts.

                    LocateRegistry.getRegistry(hostname, port);

            SmartHomeLogger.log("Found heating: " + hostname + ":" + port + "Establishing connection..");

                    //Erzeugung und Bekanntmachung eines fernaufrufbaren Objekts
                    //Das RemoteObejct liegt auf dem Server (entferntes Obejkt) /implementiert das Remote Interface
                      // und das Verhalten der für die Clients zur Verfügung stehenden entfernten Methoden.

            UnicastRemoteObject.exportObject(this, 0);

                    //Über Namensdienst ein Verweis auf das Server-Objekt abrufen
                     // -->Identifizierung über Namen, der zuvor vom Server-Objekt bei der Registrierung benutzt wurde möglich
                    // Da die lookup()-Methode untypisierte Objekte zurückliefert, muss der zurückgelieferte Verweis über einen Cast in
                    // die passende Server-Schnittstelle umgewandelt werden. In Wirklichkeit liefert die lookup()-Methode ein Exemplar des
                     // Client-Side Proxy zurück, der die Server-Schnittstelle ebenfalls implementiert.

            Remote remoteObject = Naming.lookup("//" + hostname + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (HeizungServerInterface) remoteObject;

            deviceServer.setGenericName(genericName);

            //Observer anmelden

            deviceServer.attach(this);
        }
                //UniCastRemoteObject abgeleitet (Bed.: muss einen parameterlosen Konstruktor haben,
                // --> ruft nur den Konstruktor von UnicastRemoteObject könnte sonst eine RemoteException auslösen

        catch (Exception e)

        {
            //Protokolliere den Fehler in der Variablen e
           SmartHomeLogger.log(e);
        }
    }

    public ModelVariantBean getModelVariant(){
       try {
           return deviceServer.getModelVariant();
       }
        catch (RemoteException rex){
           SmartHomeLogger.log(rex);
            return new ModelVariantBean(EModelVariant.NA);
       }

    }

    public MeasureBean getCurrentTemperature() {
        try {
            return deviceServer.getCurrentTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
        }
    }

    public MeasureBean getDesiredTemperature() {
        try {
            return deviceServer.getDesiredTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
        }
    }

    public PowerStateBean getPowerState() {
        try {
            return deviceServer.getPowerState();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new PowerStateBean(EPowerState.NA);
        }
    }

    public MessageBean setDesiredTemperature(MeasureBean new_desiredTemperature) {
        try {
            deviceServer.setDesiredTemperature(new_desiredTemperature);
            return new MessageBean(true);
        }
        catch(RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MessageBean(false);
        }
    }

    public MessageBean setPowerState(PowerStateBean new_powerState) {
        try {
            deviceServer.setPowerState(new_powerState);
            return new MessageBean(true);
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MessageBean(false);
        }
    }

    @Override
    public void update(Object o, Object change) { //Wird bei Benachrichtigungen vom Observable aufgerufen.
        SmartHomeLogger.log("BuderusHeatingDriver: Detected a change! [" + o.toString() + "]");
        //Protkollierung
        notifyObservers(change); // Informiert alle "Beobachter" über Änderung
    }

}

