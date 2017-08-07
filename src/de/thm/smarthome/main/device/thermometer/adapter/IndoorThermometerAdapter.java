package de.thm.smarthome.main.device.thermometer.adapter;

import de.electriccompany.driver.thermometer.IndoorThermometerDriver;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerAdapter extends AObservable implements IThermometer, IObserver
{
    private IndoorThermometerDriver driver;
    private ManufacturerBean manufacturer = new ManufacturerBean(EDeviceManufacturer.ELECTRIC_COMPANY);

    public IndoorThermometerAdapter(IndoorThermometerDriver driver) {
        this.driver = driver;
        this.driver.attach(this);
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("IndoorThermometerAdapter: Detected a change! [" + o.toString() + "]");
        notifyObservers(changed);
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
        return driver.getTemperature();
    }
}
