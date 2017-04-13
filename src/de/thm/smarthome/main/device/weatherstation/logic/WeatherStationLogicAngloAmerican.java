package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationLogicAngloAmerican implements IWeatherStationLogic{
    private IWeatherStationModel model;
    private IWeatherStation device;

    public WeatherStationLogicAngloAmerican(IWeatherStationModel model, IWeatherStation device) {
        this.model = model;
        this.device = device;
        if(model.isMetric()){
            model.toggleMeasuringUnit();
        }
    }

    @Override
    public void setWindVelocity(double windVelocity) {

    }

    @Override
    public void setRainfallAmount(double rainfallAmount) {

    }

    @Override
    public void setAirHumidity(double airHumidity) {

    }

    @Override
    public void setAirPressure(double airPressure) {

    }

    @Override
    public void setTemperature(double temperature) {

    }
}
