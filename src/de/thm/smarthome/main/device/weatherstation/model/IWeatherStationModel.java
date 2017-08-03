package de.thm.smarthome.main.device.weatherstation.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IWeatherStationModel
{
    MeasureBean getTemperature();
    void setTemperature(MeasureBean temperature);
    MeasureBean getWindVelocity();
    void setWindVelocity(MeasureBean windVelocity);
    MeasureBean getRainfallAmount();
    void setRainfallAmount(MeasureBean rainfallAmount);
    MeasureBean getAirPressure();
    void setAirPressure(MeasureBean airPressure);
    MeasureBean getAirHumidity();
    void setAirHumidity(MeasureBean airHumidity);
    ModelVariantBean getModelVariant();
    void setModelVariant(ModelVariantBean modelVariant);
    ManufacturerBean getManufacturer();
    void setManufacturer(ManufacturerBean manufacturer);
    ActionModeBean getActionMode();
    void setActionMode(ActionModeBean actionMode);
    String getGenericName();
    void setGenericName(String genericName);
    String getSerialnumber();
    void setSerialnumber(String serialnumber);
    void attach(Object observer);
    void setDevice(IWeatherStation device);
}
