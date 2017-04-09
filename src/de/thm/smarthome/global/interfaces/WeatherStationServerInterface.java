package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;

import java.rmi.Remote;

/**
 * Created by Tim on 07.04.2017.
 */
public interface WeatherStationServerInterface extends Remote {

    public double getWindVelocity(WeatherStationClientInterface c);

    public double getRainfallAmount(WeatherStationClientInterface c);

    public double getAirHumidity(WeatherStationClientInterface c);

    public double getAirPressure(WeatherStationClientInterface c);

    public double getTemperature(WeatherStationClientInterface c);

    public string getName(WeatherStationClientInterface c);

    public void update(AObservable o, Object change, WeatherStationClientInterface c);
}
