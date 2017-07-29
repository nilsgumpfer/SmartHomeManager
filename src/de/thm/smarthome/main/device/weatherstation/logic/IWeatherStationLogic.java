package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IWeatherStationLogic
{
    MeasureBean getTemperature();
    MeasureBean getWindVelocity();
    MeasureBean getRainfallAmount();
    MeasureBean getAirHumidity();
    MeasureBean getAirPressure();
    ModelVariantBean getModelVariant();
    ManufacturerBean getManufacturer();
    ActionModeBean getActionMode();
    String getGenericName();
    String getSerialnumber();
    WeatherStationTransferObject getWeatherStationData();

    IWeatherStationModel getModel();
    IWeatherStation getAdapter();

    void attach(IObserver observer);
}
