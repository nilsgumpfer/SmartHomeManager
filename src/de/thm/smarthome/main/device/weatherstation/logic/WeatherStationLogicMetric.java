package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationLogicMetric implements IWeatherStationLogic {
    private IWeatherStationModel model;
    private IWeatherStation device;

    public WeatherStationLogicMetric(IWeatherStationModel model, IWeatherStation device) {
        this.model = model;
        this.device = device;
    }

    @Override
    public double getWindVelocity() {
        return 0;
    }

    @Override
    public double getRainfallAmount() {
        return 0;
    }

    @Override
    public double getAirHumidity() {
        return 0;
    }

    @Override
    public double getAirPressure() {
        return 0;
    }

    @Override
    public double getTemperature() {
        return 0;
    }
}
