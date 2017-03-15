package de.thm.smarthome.main.device.thermometer.adapter;

import de.indoorthermometer.driver.thermometer.IndoorThermometerDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerAdapter extends AObservable implements IThermometer, IObserver{

    private IndoorThermometerDriver driver;

    public IndoorThermometerAdapter(String serialNumber){

        driver = new IndoorThermometerDriver(serialNumber);
    }

    @Override
    public double getTemperature() {
        return driver.getTemperature();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
