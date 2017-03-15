package de.thm.smarthome.main.device.weatherstation.adapter;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IWeatherStation {

    double getTemperature();
    double getWindVelocity();
    double getAirPressure();
    double getRainfallAmount();
}
