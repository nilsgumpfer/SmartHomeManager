package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.viessmann.driver.heating.ViessmannHeatingDriver;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class ViessmannHeatingAdapter extends AObservable implements IHeating, IObserver{

    ViessmannHeatingDriver driver;

    public ViessmannHeatingAdapter(String serialNumber){

        driver = new ViessmannHeatingDriver(serialNumber);
    }

    @Override
    public boolean setTemperature(double temperature) {

        return driver.adjustTemperature(temperature);
    }

    @Override
    public double getTemperature() {

        return driver.getCurrentTemperature();
    }

    @Override
    public void standby() {

        driver.standby();
    }

    @Override
    public void wakeup() {

        driver.wakeUp();
    }

    @Override
    public List<String> getLogs() {

        return driver.getLogs();
    }

    @Override
    public void update(AObservable o, Object change) {

    }

    @Override
    public boolean setMaxWaterLevel(double new_maxWL){
        return driver.setMaxWaterLevel(new_maxWL);
    }

    @Override
    public boolean setMinWaterLevel(double new_minWL){
        return driver.setMinWaterLevel(new_minWL);
    }

    @Override
    public boolean setMaxTemperature(double new_maxTemperature){
        return driver.setMaxTemperature(new_maxTemperature);
    }

    @Override
    public boolean setMinTemperature(double new_minTemperature){
        return driver.setMinTemperature(new_minTemperature);
    }
}
