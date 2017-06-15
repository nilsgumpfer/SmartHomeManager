package de.electriccompany.driver.shutter;

import HeizungServer.interfaces.HeizungServerInterface;
import ShutterServer.interfaces.ShutterClientInterface;
import ShutterServer.interfaces.ShutterServerInterface;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterDriver implements ShutterClientInterface {
    private ShutterServerInterface deviceServer;

    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;

    public ElectricShutterDriver(String serialnumber, String genericName)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;

        readModelVariantInformation();

        initConnection();
    }

    private void readModelVariantInformation() {
        modelVariant = new ModelVariantBean(EDeviceManufacturer.ELECTRIC_COMPANY, serialnumber);
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant.getModelVariant_String();
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Electric Company Shutter: " + modelVariant.getModelVariant_String() + "..");

            LocateRegistry.getRegistry(host, port);

            SmartHomeLogger.log("Found shutter: " + host + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + host + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (ShutterServerInterface) remoteObject;

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

    public PositionBean getCurrentPosition() {
        return deviceServer.getCurrentTemperature();
    }

    public PositionBean getDesiredPosition() {
        return deviceServer.getDesiredTemperature();
    }

    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return deviceServer.setDesiredPosition(desiredPosition);
    }
}

