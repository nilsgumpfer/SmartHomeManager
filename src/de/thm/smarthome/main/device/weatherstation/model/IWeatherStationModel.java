package de.thm.smarthome.main.device.weatherstation.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IWeatherStationModel {
    double getWindVelocity();
    void setWindVelocity(double windVelocity);
    double getRainfallAmount();
    void setRainfallAmount(double rainfallAmount);
    double getAirHumidity();
    void setAirHumidity(double airHumidity);
    double getAirPressure();
    void setAirPressure(double airPressure);
    double getTemperature();
    void setTemperature(double temperature);
    boolean isMetric();
    void toggleMeasuringUnit();
}
