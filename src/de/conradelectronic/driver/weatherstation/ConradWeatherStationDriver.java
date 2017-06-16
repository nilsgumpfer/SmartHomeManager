package de.conradelectronic.driver.weatherstation;

import WeatherStationServer.interfaces.WeatherStationClientInterface;
import WeatherStationServer.interfaces.WeatherStationServerInterface;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationDriver implements WeatherStationClientInterface {
    private WeatherStationServerInterface deviceServer;

    private String modelVariant;
    private String genericName;
    private String serialnumber;

    public ConradWeatherStationDriver(String serialnumber, String genericName)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;

        readModelVariantInformation();

        initConnection();
    }

    private void readModelVariantInformation() {
        //TODO: Switch-Case o.Ä. zur Ermittlung des Modells
        modelVariant = "Weatherstation3000";
    }

    private void initConnection()
    {
        //TODO: get IP Address for host-name
        String host = modelVariant;
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Conrad Electronic Weather Station: " + modelVariant + "..");

            LocateRegistry.getRegistry(host, port);

            SmartHomeLogger.log("Found thermometer: " + host + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + host + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (WeatherStationServerInterface) remoteObject;

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
    public double getWindVelocity() {
        return deviceServer.getWindVelocity();
    }
    public double getAirHumidity() {
        return deviceServer.getAirHumidity();
    }
    public double getAirPressure() {
        return deviceServer.getAirPressure();
    }
    public double getRainfallAmount() { return deviceServer.getRainfallAmount(); }
}
