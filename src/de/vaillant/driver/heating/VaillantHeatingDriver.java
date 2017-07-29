package de.vaillant.driver.heating;

import HeizungServer.interfaces.HeizungClientInterface;
import HeizungServer.interfaces.HeizungServerInterface;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class VaillantHeatingDriver implements HeizungClientInterface{
    private HeizungServerInterface deviceServer;

    //TODO: Modelvariant besprechen
    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;
    private String hostname;

    public VaillantHeatingDriver(String serialnumber, String genericName) {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;

        readModelVariantInformation();

        initConnection();
    }

    //TODO: macht das Sinn? Ist das so gedacht/richtig?
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

        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        //modelVariant = "Heating3000";

    }

    private void initConnection()
    {
        //Viessmann Heating-3000X38743 --> Treiber "weiß": hostname für diese heizung lautet "Heating3000" --> IP wird durch RMI-Methode auf Basis des hostnamen ermittelt

        //TODO: get IP Address for host-name
        //String host = modelVariant.getModelVariant_String();
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Buderus heating: " + modelVariant + "..");

            LocateRegistry.getRegistry(hostname, port);

            SmartHomeLogger.log("Found heating: " + hostname + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + hostname + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (HeizungServerInterface) remoteObject;

            deviceServer.setGenericName(genericName);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
    }

    public ModelVariantBean getModelVariant(){
        try {
            return modelVariant = deviceServer.getModelVariant();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return null;
        }
    }

    public MeasureBean getCurrentTemperature() {
        try {
            return deviceServer.getCurrentTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return null;
        }
    }

    public MeasureBean getDesiredTemperature() {
        try {
            return deviceServer.getDesiredTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return null;
        }
    }

    public PowerStateBean getPowerState() {
        try {
            return deviceServer.getPowerState();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return null;
        }
    }

    public MessageBean setDesiredTemperature(MeasureBean new_desiredTemperature) {
        try {
            deviceServer.setDesiredTemperature(new_desiredTemperature);
            return new MessageBean(true);
        }
        catch(RemoteException ex){
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

    //TODO: 1:1 wie Buderus-Treiber (kopieren, sobald final codiert)
}
