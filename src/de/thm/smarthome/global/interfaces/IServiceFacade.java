package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.transfer.*;

import java.util.List;

/**
 * Created by Nils on 04.02.2017.
 */
public interface IServiceFacade {
    String getServerrInfo();

    CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating);
    CommandResponseObject deleteHeating(UserTransferObject authentication);
    CommandResponseObject switchHeatingOn(UserTransferObject authentication);
    CommandResponseObject switchHeatingOff(UserTransferObject authentication);
    CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature);
    double getHeatingTemperature(UserTransferObject authentication);
    HeatingTransferObject getHeatingData(UserTransferObject authentication);

    CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter);
    CommandResponseObject moveShuttersUp(UserTransferObject authentication);
    CommandResponseObject moveShuttersDown(UserTransferObject authentication);
    String getShutterPosition(UserTransferObject authentication);
    ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter);
    List<ShutterTransferObject> getAllShutterData(UserTransferObject authentication);

    CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user);
    CommandResponseObject login(UserTransferObject authentication, UserTransferObject login);
    CommandResponseObject logout(UserTransferObject authentication, UserTransferObject logout);
    UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user);
    List<UserTransferObject> getAllUserData(UserTransferObject authentication);

    CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation);
    CommandResponseObject deleteWeatherStation(UserTransferObject authentication);
    double getAirHumidity(UserTransferObject authentication);
    double getAitPressure(UserTransferObject authentication);
    double getWindVelocity(UserTransferObject authentication);
    double getOutdoorTemperature(UserTransferObject authentication);
    double getRainfallAmount(UserTransferObject authentication);
    WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication);

    CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer);
    CommandResponseObject deleteThermometer(UserTransferObject authentication);
    double getIndoorTemperature(UserTransferObject authentication);
    ThermometerTransferObject getThermometerData(UserTransferObject authentication);

    String[] showLogs(UserTransferObject authentication, int limit);

    CommandResponseObject undoLastCommand();
}
