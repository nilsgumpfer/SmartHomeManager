package de.thm.smarthome.main.device.weatherstation.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IWeatherStationLogic {
    void setWindVelocity(double windVelocity);
    void setRainfallAmount(double rainfallAmount);
    void setAirHumidity(double airHumidity);
    void setAirPressure(double airPressure);
    void setTemperature(double temperature);
}
