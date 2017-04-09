package de.thm.smarthome.main.device.weatherstation.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.WeatherStationClientInterface;
import de.thm.smarthome.global.interfaces.WeatherStationServerInterface;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Tim on 07.04.2017.
 */
public class WeatherStation extends AObservable implements ISmartDevice, IObserver, WeatherStationServerInterface {
    private IWeatherStationLogic logic;

    public WeatherStation(IWeatherStationLogic logic) {

        this.logic = logic;
    }

    public double getWindVelocity(WeatherStationClientInterface c) {

        //return IWeatherStationLogic.getWindVelocity();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getRainfallAmount(WeatherStationClientInterface c) {

        //return IWeatherStationLogic.getRainfallAmount();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getAirHumidity(WeatherStationClientInterface c) {

        //return IWeatherStationLogic.getAirHumidity();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getAirPressure(WeatherStationClientInterface c) {

        //return IWeatherStationLogic.getAirPressure();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getTemperature(WeatherStationClientInterface c) {
        //return IWeatherStationLogic.getTemperature();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    @Override
    public String getName(WeatherStationClientInterface c) {
        return null;
    }

    @Override
    public void update(AObservable o, Object change, WeatherStationClientInterface c) {

    }

    public void startServer(String wetterstationname) throws RemoteException {
        WeatherStationServerInterface stub = (WeatherStationServerInterface) UnicastRemoteObject.exportObject(this, 0);
        LocateRegistry.createRegistry(51000);
        try {
            /*Aktiviert und definiert das Logging des Servers*/
            RemoteServer.setLog(System.out);
            /*Bindet den Server an die folgende Adresse*/
            Naming.rebind("//127.0.0.1/" + wetterstationname, this);
            System.out.println("Server ist gestartet!");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
