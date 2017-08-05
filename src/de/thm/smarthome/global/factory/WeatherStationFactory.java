package de.thm.smarthome.global.factory;

import de.conradelectronic.driver.weatherstation.ConradWeatherStationDriver;
import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.main.device.weatherstation.adapter.ConradWeatherStationAdapter;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMetric;
import de.thm.smarthome.main.device.weatherstation.model.WeatherStationModel;

public class WeatherStationFactory {
    public static SmartWeatherStation createWeatherStation(ManufacturerBean manufacturerBean, ModelVariantBean modelVariantBean, String genericName, String serialnumber){
        return new SmartWeatherStation(
                new WeatherStationLogicMetric(
                        new WeatherStationModel(
                                modelVariantBean,
                                manufacturerBean,
                                new ActionModeBean(EActionMode.METRIC),
                                genericName,
                                serialnumber
                        ),
                        new ConradWeatherStationAdapter(
                                new ConradWeatherStationDriver(serialnumber,genericName, modelVariantBean)
                        )));
    }
}
