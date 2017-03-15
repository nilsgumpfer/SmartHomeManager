package de.thm.smarthome.main.manager.controller;

import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

import java.util.List;

/**
 * Created by Nils on 05.02.2017.
 */
public interface IDeviceManager {
    SmartHeating getSmartHeating();
    List<SmartShutter> getSmartShutters();
    SmartThermometer getSmartThermometer();
    int setSmartHeating(SmartHeating smartHeating);
    SmartWeatherStation getSmartWeatherStation();
    int setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    int setSmartThermometer(SmartThermometer smartThermometer);
    SmartShutter getSmartShutter(String id);
    int addSmartShutter(SmartShutter smartShutter);
}
