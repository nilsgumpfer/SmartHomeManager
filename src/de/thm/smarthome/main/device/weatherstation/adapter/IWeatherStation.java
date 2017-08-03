package de.thm.smarthome.main.device.weatherstation.adapter;

import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IWeatherStation
{
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    MeasureBean getTemperature();
    MeasureBean getRainfallAmount();
    MeasureBean getWindVelocity();
    MeasureBean getAirHumidity();
    MeasureBean getAirPressure();
    void attach(Object observer);
}
