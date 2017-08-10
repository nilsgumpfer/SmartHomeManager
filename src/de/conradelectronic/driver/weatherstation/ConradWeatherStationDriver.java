package de.conradelectronic.driver.weatherstation;

import WeatherStationServer.interfaces.WeatherStationClientInterface;
import WeatherStationServer.interfaces.WeatherStationServerInterface;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created on 27.01.2017.
 */
public class ConradWeatherStationDriver extends AObservable implements WeatherStationClientInterface, IObserver {
    private WeatherStationServerInterface deviceServer;

    private ModelVariantBean modelVariant;
    private String genericName;
    private String serialnumber;
    private String hostname;

    public ConradWeatherStationDriver(String serialnumber, String genericName, ModelVariantBean modelVariantBean)
    {
        this.serialnumber   = serialnumber;
        this.genericName    = genericName;
        this.modelVariant   = modelVariantBean;


        hostname = "192.168.178.20";
        //readModelVariantInformation();

        initConnection();
    }

    private void readModelVariantInformation() {
        switch (modelVariant.getModelVariant_Enum()){
            case  WeatherStation3000:
                hostname = modelVariant.getModelVariant_String();
                break;
        }
    }

    private void initConnection()
    {
        int port    = 0;

        try {

            SmartHomeLogger.log("Looking for Conrad Electronic Weather Station: " + modelVariant + "..");

            LocateRegistry.getRegistry(hostname, port);

            SmartHomeLogger.log("Found thermometer: " + hostname + ":" + port + "Establishing connection..");

            UnicastRemoteObject.exportObject(this, 0);

            Remote remoteObject = Naming.lookup("//" + hostname + "/" + "SmartHomeAPI");

            SmartHomeLogger.log("Successfully connected.");

            deviceServer = (WeatherStationServerInterface) remoteObject;

            deviceServer.setGenericName(genericName);

            deviceServer.attach(this);
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
        try{
            return deviceServer.getTemperature();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.00, EUnitOfMeasurement.NA);
        }

    }
    public MeasureBean getWindVelocity() {
        try {
            return deviceServer.getWindvelocity();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.00, EUnitOfMeasurement.NA);
        }

    }
    public MeasureBean getAirHumidity() {
        try {
            return deviceServer.getAirHumidity();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.00, EUnitOfMeasurement.NA);
        }

    }
    public MeasureBean getAirPressure() {
        try {
            return deviceServer.getAirPressure();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.00, EUnitOfMeasurement.NA);
        }

    }
    public MeasureBean getRainfallAmount() {
        try {
            return deviceServer.getRainfallAmount();
        }
        catch (RemoteException rex){
            SmartHomeLogger.log(rex);
            return new MeasureBean(0.00, EUnitOfMeasurement.NA);
        }

    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("ConradWeatherStationDriver: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

}
