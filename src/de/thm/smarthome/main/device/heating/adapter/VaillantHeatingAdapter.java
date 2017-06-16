package de.thm.smarthome.main.device.heating.adapter;

import de.buderus.driver.heating.BuderusHeatingDriver;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;
import de.vaillant.driver.heating.VaillantHeatingDriver;

/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class VaillantHeatingAdapter extends AObservable implements IHeating, IObserver
{
    private VaillantHeatingDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.BUDERUS);

    public VaillantHeatingAdapter(VaillantHeatingDriver vaillantHeatingDriver) {
        this.driver = vaillantHeatingDriver;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return new MeasureBean(driver.getCurrentTemperature(), EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return new MeasureBean(driver.getDesiredTemperature(), EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return new ModelVariantBean(EDeviceManufacturer.BUDERUS, driver.getModelVariant());
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public PowerStateBean getPowerState() {
        return new PowerStateBean(driver.getPowerState());
    }

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return new MessageBean(driver.setDesiredTemperature(temperature.getMeasure_Double()));
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return new MessageBean(driver.setPowerState(powerState.getPowerState_Boolean()));
    }

}