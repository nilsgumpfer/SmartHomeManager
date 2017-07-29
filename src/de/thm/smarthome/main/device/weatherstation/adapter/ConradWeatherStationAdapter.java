package de.thm.smarthome.main.device.weatherstation.adapter;

import de.conradelectronic.driver.weatherstation.ConradWeatherStationDriver;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationAdapter extends AObservable implements IWeatherStation, IObserver
{
    private ConradWeatherStationDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.CONRAD_ELECTRONIC);

    public ConradWeatherStationAdapter(ConradWeatherStationDriver driver) {
        this.driver = driver;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
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
    public MeasureBean getTemperature() {
        return new MeasureBean(driver.getTemperature().getMeasure_Double(), EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    }

    @Override
    public MeasureBean getRainfallAmount() {
        return new MeasureBean(driver.getRainfallAmount().getMeasure_Double(), EUnitOfMeasurement.VOLUME_LITRESPERSQUAREMETER);
    }

    @Override
    public MeasureBean getWindVelocity() { return new MeasureBean(driver.getWindVelocity().getMeasure_Double(), EUnitOfMeasurement.VELOCITY_KILOMETERSPERHOUR);
    }

    @Override
    public MeasureBean getAirHumidity() {
        return new MeasureBean(driver.getAirHumidity().getMeasure_Double(), EUnitOfMeasurement.RELATION_PERCENT);
    }

    @Override
    public MeasureBean getAirPressure() {
        return new MeasureBean(driver.getAirPressure().getMeasure_Double(), EUnitOfMeasurement.PRESSURE_BAR);
    }
}
