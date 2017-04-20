package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IHeatingLogic {
    String getHeatingName();
    String getHeatingModeName();
    void setHeatingModeName(String heatingModeName);
    ResponseCode setTemperature(double temperature);
    double getTemperature();
    ResponseCode switchOn();
    ResponseCode switchOff();
}
