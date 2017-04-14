package de.thm.smarthome.main.device.heating.logic;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IHeatingLogic {
    String getHeatingName();
    void setHeatingName(String heatingName);
    String getHeatingModeName();
    void setHeatingModeName(String heatingModeName);
    int setTemperature(double temperature);
    double getTemperature();
}
