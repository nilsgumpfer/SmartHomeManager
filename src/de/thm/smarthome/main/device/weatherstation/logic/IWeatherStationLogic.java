package de.thm.smarthome.main.device.weatherstation.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IWeatherStationLogic {
    static double getWindVelocity();
    static double getRainfallAmount();
    static double getAirHumidity();
    static double getAirPressure();
    static double getTemperature();
}
