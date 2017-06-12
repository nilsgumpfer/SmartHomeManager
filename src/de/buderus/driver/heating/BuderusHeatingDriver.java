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
public class BuderusHeatingDriver implements HeizungClientInterface{

    private HeizungServerInterface deviceServer;

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

    private void readModelVariantInformation() {
        modelVariant = new ModelVariantBean(EDeviceManufacturer.BUDERUS, serialnumber);
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant.getModelVariant_String();
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Buderus heating: " + modelVariant.getModelVariant_String() + "..");

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
        return modelVariant;
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

    public MessageBean setDesiredTemperature(MeasureBean desiredTemperature) {
        return deviceServer.setDesiredTemperature(desiredTemperature);
    }

    public MessageBean setPowerState(PowerStateBean powerState) {
        return deviceServer.setPowerState(powerState);
    }
}

