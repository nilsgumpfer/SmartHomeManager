package de.thm.smarthome.main.device.heating.adapter;

//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

import de.thm.smarthome.global.enumeration.ResponseCode;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IHeating {
    boolean setTemperature(double temperature);
    double getTemperature();
    void standby();
    void wakeup();
    List<String> getLogs();
    boolean setMaxTemperature(double new_maxTemperature);
    boolean setMinTemperature(double new_minTemperature);
    boolean setMaxWaterLevel(double new_maxWL);
    boolean setMinWaterLevel(double new_minWL);
    double getMaxTemperature();
    double getMinTemperature();
    double getMaxWaterLevel();
    double getMinWaterLevel();
    ResponseCode switchOn();
    ResponseCode switchOff();
}
