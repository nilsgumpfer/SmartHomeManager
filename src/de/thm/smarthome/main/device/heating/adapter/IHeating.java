package de.thm.smarthome.main.device.heating.adapter;

import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

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
}
