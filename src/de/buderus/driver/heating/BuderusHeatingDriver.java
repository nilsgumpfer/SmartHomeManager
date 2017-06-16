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

    private String modelVariant;
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
        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        modelVariant = "Heating3000";
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant;
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

    public String getModelVariant() {
        return modelVariant;
    }

    public double getCurrentTemperature() {
        return deviceServer.getCurrentTemperature();
    }

    public double getDesiredTemperature() {
        return deviceServer.getDesiredTemperature();
    }

    public boolean getPowerState() {
        return deviceServer.getPowerState();
    }

    public boolean setDesiredTemperature(double desiredTemperature) {
        return deviceServer.setDesiredTemperature(desiredTemperature);
    }

    public boolean setPowerState(boolean powerState) {
        return deviceServer.setPowerState(powerState);
    }
}

