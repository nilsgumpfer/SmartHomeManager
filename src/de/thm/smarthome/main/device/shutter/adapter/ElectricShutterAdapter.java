package de.thm.smarthome.main.device.shutter.adapter;

import de.electricshutter.driver.shutter.ElectricShutterDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterAdapter extends AObservable implements IShutter, IObserver{

    ElectricShutterDriver driver;

    public ElectricShutterAdapter(String serialNumber){

        driver = new ElectricShutterDriver(serialNumber);
    }

    @Override
    public void moveUp() {

        driver.moveUp();
    }

    @Override
    public void moveDown() {

        driver.moveDown();
    }

    @Override
    public boolean isUp() {
        return driver.isUp();
    }

    @Override
    public boolean isDown() {
        return driver.isDown();
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
