package de.electriccompany.driver.thermometer;

import ThermometerServer.interfaces.ThermometerClientInterface;
import ThermometerServer.interfaces.ThermometerServerInterface;
import de.thm.smarthome.global.beans.MeasureBean;
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
public class IndoorThermometerDriver implements ThermometerClientInterface
{
    private ThermometerServerInterface deviceServer;

    private ModelVariantBean modelVariant;
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
        modelVariant = new ModelVariantBean(EDeviceManufacturer.ELECTRIC_COMPANY, serialnumber);
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant.getModelVariant_String();
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Electric Company Thermometer: " + modelVariant.getModelVariant_String() + "..");

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

    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    public MeasureBean getTemperature() {
        return deviceServer.getTemperature();
    }

}
