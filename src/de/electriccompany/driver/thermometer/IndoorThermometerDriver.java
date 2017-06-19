package de.electriccompany.driver.thermometer;

import ThermometerServer.interfaces.ThermometerClientInterface;
import ThermometerServer.interfaces.ThermometerServerInterface;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerDriver implements ThermometerClientInterface
{
    private ThermometerServerInterface deviceServer;

    private String modelVariant;
    private String genericName;
    private String serialnumber;

    public IndoorThermometerDriver(String serialnumber, String genericName)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;

        readModelVariantInformation();

        initConnection();
    }

    private void readModelVariantInformation() {
        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        modelVariant = "Thermometer3000";
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant;
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Electric Company Thermometer: " + modelVariant + "..");

            LocateRegistry.getRegistry(host, port);

            SmartHomeLogger.log("Found thermometer: " + host + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + host + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (ThermometerServerInterface) remoteObject;

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

    public double getTemperature() {
        return deviceServer.getTemperature();
    }

}
