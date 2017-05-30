package de.thm.smarthome.main.device.thermometer.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IThermometerModel {
    void setName(String name);
    String getName();
    void setTemperature(double temperature);
    void toggleTemperatureUnit();
    String getThermometerName();
    String getThermometerManufacturer();
    String getThermometerModel();
    String getThermometerSerialnumber();
    double getThermometerTemperature();
    boolean isCelsius();
}
