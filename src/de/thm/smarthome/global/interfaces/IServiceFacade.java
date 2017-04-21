package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.observer.IHeatingObserver;
import de.thm.smarthome.global.observer.IShutterObserver;
import de.thm.smarthome.global.observer.IThermometerObserver;
import de.thm.smarthome.global.observer.IWeatherstationObserver;
import de.thm.smarthome.global.transfer.*;

/**
 * Created by Nils on 04.02.2017.
 */
public interface IServiceFacade {
    String getServerInfo();

    CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating);
    CommandResponseObject deleteHeating(UserTransferObject authentication);
    CommandResponseObject switchHeatingOn(UserTransferObject authentication);
    CommandResponseObject switchHeatingOff(UserTransferObject authentication);
    CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature);
    HeatingTransferObject getHeatingTemperature(UserTransferObject authentication);
    HeatingTransferObject getHeatingData(UserTransferObject authentication);
    //void attachHeatingObserver(UserTransferObject authentication, IHeatingObserver heatingObserver);

    CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject moveAllShuttersUp(UserTransferObject authentication);
    CommandResponseObject moveAllShuttersDown(UserTransferObject authentication);
    CommandResponseObject moveShutterUp(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);
    CommandResponseObject moveShutterDown(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);
    ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);
    ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);
    ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter);
    ShutterTransferObject[] getAllShutterData(UserTransferObject authentication);
    //void attachShutterObserver(UserTransferObject authentication, IShutterObserver shutterObserver);

    CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject login(UserTransferObject user);
    CommandResponseObject logout(UserTransferObject authentication, UserTransferObject user);
    UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user);
    UserTransferObject[] getAllUserData(UserTransferObject authentication);

    CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation);
    CommandResponseObject deleteWeatherStation(UserTransferObject authentication);
    WeatherStationTransferObject getAirHumidity(UserTransferObject authentication);
    WeatherStationTransferObject getAirPressure(UserTransferObject authentication);
    WeatherStationTransferObject getWindVelocity(UserTransferObject authentication);
    WeatherStationTransferObject getOutdoorTemperature(UserTransferObject authentication);
    WeatherStationTransferObject getRainfallAmount(UserTransferObject authentication);
    WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication);
    //void attachWeatherstationObserver(UserTransferObject authentication, IWeatherstationObserver weatherstationObserver);

    CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer);
    CommandResponseObject deleteThermometer(UserTransferObject authentication);
    ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication);
    ThermometerTransferObject getThermometerData(UserTransferObject authentication);
    //void attachThermometerObserver(UserTransferObject authentication, IThermometerObserver thermometerObserver);

    String[] readLogs(UserTransferObject authentication, int limit);

    CommandResponseObject undoLastCommand(UserTransferObject authentication);

    String getMessage(ResponseCode responseCode);
}
