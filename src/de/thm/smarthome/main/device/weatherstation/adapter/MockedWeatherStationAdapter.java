package de.thm.smarthome.main.device.weatherstation.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created on 27.01.2017.
 */
public class MockedWeatherStationAdapter extends AObservable implements IWeatherStation, IObserver
{
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.NA);

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("MockedWeatherStationAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    //GETTER//

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

    @Override
    public MeasureBean getRainfallAmount() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getWindVelocity() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getAirHumidity() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getAirPressure() {
        return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }
}
