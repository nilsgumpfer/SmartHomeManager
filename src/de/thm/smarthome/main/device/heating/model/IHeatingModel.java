package de.thm.smarthome.main.device.heating.model;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IHeatingModel {
    void setName(String name);
    String getName();
    double getTemperature();
    void setTemperature(double temperature);
}
