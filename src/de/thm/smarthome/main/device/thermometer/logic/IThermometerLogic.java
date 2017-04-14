package de.thm.smarthome.main.device.thermometer.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IThermometerLogic {
    void setTemperatureUnit();
    double getTemperature();
    void setTemperatureUnit(double temperature);
}
