package de.thm.smarthome.main.manager.controller.devicemanager;

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
    void setSmartHeating(SmartHeating smartHeating);
    SmartWeatherStation getSmartWeatherStation();
    void setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    void setSmartThermometer(SmartThermometer smartThermometer);
    SmartShutter getSmartShutter(String id);
    void addSmartShutter(SmartShutter smartShutter);
}
