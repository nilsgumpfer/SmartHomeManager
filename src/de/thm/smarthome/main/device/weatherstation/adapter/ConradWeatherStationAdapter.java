package de.thm.smarthome.main.device.weatherstation.adapter;

import de.conrad.driver.weatherstation.ConradWeatherStationDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationAdapter extends AObservable implements IWeatherStation, IObserver{

    ConradWeatherStationDriver driver;

    public ConradWeatherStationAdapter(String serialNumber){

        driver = new ConradWeatherStationDriver(serialNumber);
    }

    @Override
    public double getTemperature() {
        return driver.getTemperature();
    }

    @Override
    public double getWindVelocity() {
        return driver.getWindVelocity();
    }

    @Override
    public double getAirPressure() {
        return driver.getAirPressure();
    }

    @Override
    public double getRainfallAmount() {
        return driver.getRainfallAmount();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
