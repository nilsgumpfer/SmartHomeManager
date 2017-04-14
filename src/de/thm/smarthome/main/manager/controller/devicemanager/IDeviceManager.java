package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

/**
 * Created by Nils on 05.02.2017.
 */
public interface IDeviceManager {
    SmartHeating getSmartHeating();
    void setSmartHeating(SmartHeating smartHeating);
    ResponseCode createSmartHeating(HeatingTransferObject heatingTransferObject);
    ResponseCode deleteSmartHeating();

    SmartShutter getSmartShutter(String id);
    void addSmartShutter(SmartShutter smartShutter);
    void removeSmartShutter(SmartShutter smartShutter);
    int createSmartShutter(ShutterTransferObject shutterTransferObject);

    SmartThermometer getSmartThermometer();
    void setSmartThermometer(SmartThermometer smartThermometer);
    int createSmartThermometer(ThermometerTransferObject thermometerTransferObject);

    SmartWeatherStation getSmartWeatherStation();
    void setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    int createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject);
}
