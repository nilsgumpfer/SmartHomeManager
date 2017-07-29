package de.thm.smarthome.main.device.heating.adapter;

import de.buderus.driver.heating.BuderusHeatingDriver;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class ViessmannHeatingAdapter extends AObservable implements IHeating, IObserver{

    private BuderusHeatingDriver driver;
            //TODO: Change back to:
            // ViessmannHeatingDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.VIESSMANN);

    //public ViessmannHeatingAdapter(ViessmannHeatingDriver driver) {
    public ViessmannHeatingAdapter(BuderusHeatingDriver driver) {
        this.driver = driver;
        this.driver.attach(this);
    }

    @Override
    public void update(AObservable o, Object change) {
        SmartHomeLogger.log("ViessmannHeatingAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return driver.getCurrentTemperature();
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return driver.getDesiredTemperature();
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return driver.getModelVariant();
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public PowerStateBean getPowerState() {
        return driver.getPowerState();
    }

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return driver.setDesiredTemperature(temperature);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return driver.setPowerState(powerState);
    }
}
