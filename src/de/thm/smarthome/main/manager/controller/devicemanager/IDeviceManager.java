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
    void setSmartHeating(SmartHeating smartHeating);

    SmartShutter getSmartShutter(String id);
    void addSmartShutter(SmartShutter smartShutter);
    void removeSmartShutter(SmartShutter smartShutter);

    SmartThermometer getSmartThermometer();
    void setSmartThermometer(SmartThermometer smartThermometer);

    SmartWeatherStation getSmartWeatherStation();
    void setSmartWeatherStation(SmartWeatherStation smartWeatherStation);

}
