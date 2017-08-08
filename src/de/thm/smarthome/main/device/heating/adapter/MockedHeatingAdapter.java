package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;



/**
 * Created on 27.01.2017.
 * Changed 28.01.2017
 */
public class MockedHeatingAdapter extends AObservable implements IHeating, IObserver
{
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.NA);

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("MockedHeatingAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    //SETTER//
    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return new MessageBean(false);
    }

    //GETTER//

    @Override
    public MeasureBean getCurrentTemperature() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return new ModelVariantBean(EModelVariant.NA);
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public PowerStateBean getPowerState() {
        return new PowerStateBean(EPowerState.NA);
    }


}
