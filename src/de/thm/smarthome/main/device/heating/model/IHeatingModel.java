package de.thm.smarthome.main.device.heating.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IHeatingModel {
    void setHeatingName(String heatingName);
    void setHeatingMode(String heatingMode);
    String getHeatingName();
    String getHeatingManufacturer();
    String getHeatingModel();
    String getHeatingSerialnumber();
    double getTemperature();
    String getHeatingMode();
    void setTemperature(double temperature);
}
