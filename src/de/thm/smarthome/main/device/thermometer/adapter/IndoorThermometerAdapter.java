package de.thm.smarthome.main.device.thermometer.adapter;

import de.indoorthermometer.driver.thermometer.IndoorThermometerDriver;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerAdapter extends AObservable implements IThermometer, IObserver{

    private IndoorThermometerDriver driver;

    public IndoorThermometerAdapter(String serialNumber, String thermometerIP, String thermometername){

        driver = new IndoorThermometerDriver(serialNumber, thermometerIP, thermometername);
    }

    @Override
    public String getThermometerName() {
        return driver.getThermometerName();
    }

    @Override
    public String getThermometerManufacutrer() {
        return driver.getThermometerManufacturer();
    }

    @Override
    public String getThermometerModel() {
        return driver.getThermometerModel();
    }

    @Override
    public String getThermometerSerialnumber() {
        return driver.getThermometerSerialnumber();
    }

    @Override
    public double getThermometerTemperature() throws RemoteException{
        return driver.getThermometerTemperature();
    }

    @Override
    public void update(AObservable o, Object change) {

    }

}
