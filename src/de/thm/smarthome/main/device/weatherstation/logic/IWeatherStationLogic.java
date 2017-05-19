package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.global.transfer.WeatherStationTransferObject;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IWeatherStationLogic {
//    void setWindVelocity(double windVelocity);
//    void setRainfallAmount(double rainfallAmount);
//    void setAirHumidity(double airHumidity);
//    void setAirPressure(double airPressure);
//    void setTemperature(double temperature);
    void setValues();
    WeatherStationTransferObject getWeatherStationData();
}
