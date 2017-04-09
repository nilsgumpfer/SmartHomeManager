package de.thm.smarthome.main.device.weatherstation.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IWeatherStationLogic {
    double getWindVelocity();
    double getRainfallAmount();
    double getAirHumidity();
    double getAirPressure();
    double getTemperature();
}
