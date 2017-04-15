package de.thm.smarthome.global.interfaces;

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

    CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject moveAllShuttersUp(UserTransferObject authentication);
    CommandResponseObject moveAllShuttersDown(UserTransferObject authentication);
    ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);

    ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject);

    ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter);
    ShutterTransferObject[] getAllShutterData(UserTransferObject authentication);

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

    CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer);
    CommandResponseObject deleteThermometer(UserTransferObject authentication);
    ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication);
    ThermometerTransferObject getThermometerData(UserTransferObject authentication);

    String[] readLogs(UserTransferObject authentication, int limit);

    CommandResponseObject undoLastCommand();
}
