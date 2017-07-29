package de.thm.smarthome.main.manager.controller.devicemanager;

import de.thm.smarthome.global.beans.MessageBean;
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
    MessageBean setSmartHeating(SmartHeating smartHeating);
    MessageBean setSmartHeating(HeatingTransferObject heatingTransferObject);
    MessageBean createSmartHeating(HeatingTransferObject heatingTransferObject);
    MessageBean deleteSmartHeating();

    SmartShutter getSmartShutter(String serialnumber);
    MessageBean addSmartShutter(SmartShutter smartShutter);
    MessageBean deleteSmartShutter(SmartShutter smartShutter);
    SmartShutter getSmartShutter(ShutterTransferObject shutterTransferObject);
    MessageBean addSmartShutter(ShutterTransferObject shutterTransferObject);
    MessageBean deleteSmartShutter(ShutterTransferObject shutterTransferObject);
    MessageBean createSmartShutter(ShutterTransferObject shutterTransferObject);

    SmartThermometer getSmartThermometer();
    MessageBean setSmartThermometer(SmartThermometer smartThermometer);
    MessageBean setSmartThermometer(ThermometerTransferObject thermometerTransferObject);
    MessageBean createSmartThermometer(ThermometerTransferObject thermometerTransferObject);
    MessageBean deleteSmartThermometer();

    SmartWeatherStation getSmartWeatherStation();
    MessageBean setSmartWeatherStation(SmartWeatherStation smartWeatherStation);
    MessageBean createSmartWeatherStation(WeatherStationTransferObject weatherStationTransferObject);
    MessageBean deleteSmartWeatherStation();

    List<SmartShutter> getSmartShutters();

    MessageBean createSmartHeating(String modelVariant, String manufacturer, String genericName, String serialnumber);

    MessageBean createSmartShutter(String modelVariant, String manufacturer, String genericName, String serialnumber);

    MessageBean createSmartWeatherStation(String modelVariant, String manufacturer, String genericName, String serialnumber);
}
