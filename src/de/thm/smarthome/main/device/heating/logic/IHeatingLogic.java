package de.thm.smarthome.main.device.heating.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IHeatingLogic {
    void setTemperature(double temperature);
    double getTemperature();
    String getName();
}
