package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.memento.HeatingMemento;
import de.vaillant.driver.heating.VaillantHeatingDriver;
import de.viessmann.driver.heating.ViessmannHeatingDriver;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class VaillantHeatingAdapter extends AObservable implements IHeating, IObserver {

    VaillantHeatingDriver driver;

    public VaillantHeatingAdapter(String serialNumber){

        driver = new VaillantHeatingDriver(serialNumber);
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
}
