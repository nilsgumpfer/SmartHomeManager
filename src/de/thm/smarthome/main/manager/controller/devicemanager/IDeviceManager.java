package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.Shutter;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

import java.util.List;

/**
 * Created by Nils on 05.02.2017.
 */
public interface IDeviceManager {
    SmartHeating getSmartHeating();
    ResponseCode setSmartHeating(SmartHeating smartHeating);
    ResponseCode setSmartHeating(HeatingTransferObject heatingTransferObject);
    ResponseCode createSmartHeating(HeatingTransferObject heatingTransferObject);
    ResponseCode deleteSmartHeating();

    SmartShutter getSmartShutter(String id);
    ResponseCode addSmartShutter(SmartShutter smartShutter);
    ResponseCode deleteSmartShuttter(SmartShutter smartShutter);
    SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject);
    ResponseCode addSmartShutter(ShutterTransferObject shutterTransferObject);
    ResponseCode deleteSmartShuttter(ShutterTransferObject shutterTransferObject);
    ResponseCode createSmartShutter(ShutterTransferObject shutterTransferObject);

    SmartThermometer getSmartThermometer();
    ResponseCode setSmartThermometer(SmartThermometer smartThermometer);
    ResponseCode setSmartThermometer(ThermometerTransferObject thermometerTransferObject);
    ResponseCode createSmartThermometer(ThermometerTransferObject thermometerTransferObject);

    SmartWeatherStation getSmartWeatherStation();
    ResponseCode setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    ResponseCode createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject);

    List<SmartShutter> getSmartShutters();

    ResponseCode deleteSmartWeatherStation();

    ResponseCode deleteSmartThermometer();
}
