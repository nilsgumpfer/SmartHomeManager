package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

import java.util.List;

/**
 * Created by Nils on 05.02.2017.
 */
public interface IDeviceManager {
    MessageBean createSmartHeating(String modelVariant, String manufacturer, String genericName, String serialnumber);
    SmartHeating getSmartHeating();
    MessageBean deleteSmartHeating();

    MessageBean createSmartShutter(String modelVariant, String manufacturer, String genericName, String serialnumber);
    SmartShutter getSmartShutter(String serialnumber);
    List<SmartShutter> getSmartShutters();
    MessageBean deleteSmartShutter(SmartShutter smartShutter);

    MessageBean createSmartThermometer(String modelVariant, String manufacturer, String genericName, String serialnumber);
    SmartThermometer getSmartThermometer();
    MessageBean deleteSmartThermometer();

    MessageBean createSmartWeatherStation(String modelVariant, String manufacturer, String genericName, String serialnumber);
    SmartWeatherStation getSmartWeatherStation();
    MessageBean deleteSmartWeatherStation();
}
