package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.observer.IWeatherstationObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;

/**
 * Created by Nils on 12.06.2017.
 */
public class TransferObjectFactory {
    public static HeatingTransferObject getHeatingTransferObject(IHeatingModel heatingModel)
    {
        return new HeatingTransferObject(
    }

    public static ShutterTransferObject getShutterTransferObject(IShutter shutter){

    }

    public static ThermometerTransferObject getThermometerTransferObject(IThermometer thermometer){}

    public static WeatherStationTransferObject getWeatherStationTransferObject(IWeatherStation weatherStation){}
}
