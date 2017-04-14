package de.thm.smarthome.main.device.heating.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IHeatingModel {
    String getHeatingName();
    void setHeatingName(String heatingName);
    String getHeatingModeName();
    void setHeatingModeName(String name);
    double getTemperature();
    void setTemperature(double temperature);
}
