package de.thm.smarthome.global.interfaces;


import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ITemperatureRelevantDevice {
    ResponseCode setTemperature(double temperature);
    double getTemperature();
}
