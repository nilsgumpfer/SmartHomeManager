package de.thm.smarthome.main.device.weatherstation.adapter;

import de.conrad.driver.weatherstation.ConradWeatherStationDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationAdapter extends AObservable implements IWeatherStation, IObserver{

    ConradWeatherStationDriver driver;

    public ConradWeatherStationAdapter(String serialNumber, String wetterstationIP, String wetterstationname){

        driver = new ConradWeatherStationDriver(serialNumber, wetterstationIP, wetterstationname);
    }

    @Override
    public String getWeatherStationName() {
        return driver.getWeatherStationName();
    }

    @Override
    public String getWeatherStationManufacturer() {
        return driver.getWeatherStationManufacturer();
    }

    @Override
    public String getWeatherStationModel() {
        return driver.getWeatherStationModel();
    }

    @Override
    public String getWeatherStationSerialnumber() {
        return driver.getWeatherStationSerialnumber();
    }

    @Override
    public double getTemperature() throws RemoteException{
        return driver.getTemperature();
    }

    @Override
    public double getWindVelocity()throws RemoteException {
        return driver.getWindVelocity();
    }

    @Override
    public double getAirPressure()throws RemoteException {
        return driver.getAirPressure();
    }

    @Override
    public double getRainfallAmount() throws RemoteException{
        return driver.getRainfallAmount();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
