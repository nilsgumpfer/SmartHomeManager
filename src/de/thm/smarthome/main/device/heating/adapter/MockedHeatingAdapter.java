package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;


/**
 * Created by Nils on 27.01.2017.
 * Changed 28.01.2017
 */
public class MockedHeatingAdapter extends AObservable implements IHeating, IObserver
{
    private PowerStateBean powerStateBean = new PowerStateBean(EPowerState.ON);
    private MeasureBean currentTemperature = new MeasureBean(0.0, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    private MeasureBean desiredTemperature = new MeasureBean(0.0, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.VIESSMANN);
    private ModelVariantBean modelVariantBean = new ModelVariantBean(EModelVariant.HEATING_2000);

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("MockedHeatingAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return currentTemperature;
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return desiredTemperature;
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return modelVariantBean;
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public PowerStateBean getPowerState() {
        return powerStateBean;
    }

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        notifyObservers(temperature);
        return new MessageBean(true);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        this.powerStateBean = powerState;
        notifyObservers(powerState);
        return new MessageBean(true);
    }
}
