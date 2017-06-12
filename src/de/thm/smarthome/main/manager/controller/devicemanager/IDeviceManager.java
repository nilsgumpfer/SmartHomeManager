package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
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
    EMessageCode setSmartHeating(SmartHeating smartHeating);
    EMessageCode setSmartHeating(HeatingTransferObject heatingTransferObject);
    EMessageCode createSmartHeating(HeatingTransferObject heatingTransferObject);
    EMessageCode deleteSmartHeating();

    SmartShutter getSmartShutter(String id);
    EMessageCode addSmartShutter(SmartShutter smartShutter);
    EMessageCode deleteSmartShutter(SmartShutter smartShutter);
    SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject);
    EMessageCode addSmartShutter(ShutterTransferObject shutterTransferObject);
    EMessageCode deleteSmartShutter(ShutterTransferObject shutterTransferObject);
    EMessageCode createSmartShutter(ShutterTransferObject shutterTransferObject);

    SmartThermometer getSmartThermometer();
    EMessageCode setSmartThermometer(SmartThermometer smartThermometer);
    EMessageCode setSmartThermometer(ThermometerTransferObject thermometerTransferObject);
    EMessageCode createSmartThermometer(ThermometerTransferObject thermometerTransferObject);
    EMessageCode deleteSmartThermometer();

    SmartWeatherStation getSmartWeatherStation();
    EMessageCode setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    EMessageCode createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject);
    EMessageCode deleteSmartWeatherStation();

    List<SmartShutter> getSmartShutters();
}
