package de.thm.smarthome.main.device.thermometer.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class MockedThermometerAdapter extends AObservable implements IThermometer, IObserver
{
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.NA);

    @Override
    public void update(AObservable o, Object change) {
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
    public MeasureBean getTemperature() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }
}
