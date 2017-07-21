package de.buderus.driver.heating;

import HeizungServer.interfaces.HeizungClientInterface;
import HeizungServer.interfaces.HeizungServerInterface;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class BuderusHeatingDriver implements HeizungClientInterface
{
    private HeizungServerInterface deviceServer;

    //TODO: Modelvariant besprechen
    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;

    public BuderusHeatingDriver(String serialnumber, String genericName)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;

        readModelVariantInformation();

        initConnection();
    }


    //TODO: macht das Sinn? Ist das so gedacht/richtig?
    private void readModelVariantInformation() {
        switch (modelVariant.getModelVariant_String()){
                case  "Heating 3000" :
                    /*whatever*/
                    break;
            case  "Heating 2000" :
                    /*whatever*/
                break;
            case  "Heating 1000" :
                    /*whatever*/
                break;
            }

        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        //modelVariant = "Heating3000";

    }

    private void initConnection()
    {
        //Viessmann Heating-3000X38743 --> Treiber "weiß": hostname für diese heizung lautet "Heating3000" --> IP wird durch RMI-Methode auf Basis des hostnamen ermittelt

        //TODO: get IP Address for host-name
        String host = modelVariant.getModelVariant_String();
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Buderus heating: " + modelVariant + "..");

            LocateRegistry.getRegistry(host, port);

            SmartHomeLogger.log("Found heating: " + host + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + host + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (HeizungServerInterface) remoteObject;

            deviceServer.setGenericName(genericName);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
        }
    }

    public ModelVariantBean getModelVariant() {
       return modelVariant = deviceServer.getModelVariant();
    }

    public MeasureBean getCurrentTemperature() {
        return deviceServer.getCurrentTemperature();
    }

    public MeasureBean getDesiredTemperature() {
        return deviceServer.getDesiredTemperature();
    }

    public PowerStateBean getPowerState() {
        return deviceServer.getPowerState();
    }

    public MeasureBean setDesiredTemperature(double desiredTemperature) {
        return deviceServer.setDesiredTemperature(desiredTemperature);
    }

    public PowerStateBean setPowerState(boolean powerState) {
        return deviceServer.setPowerState(powerState);
    }
}

