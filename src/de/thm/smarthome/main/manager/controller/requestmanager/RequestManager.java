package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.manager.controller.IDeviceManager;
import de.thm.smarthome.main.manager.controller.DeviceManager;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManager;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManager implements IServiceFacade {
    private static RequestManager ourInstance = new RequestManager();

    private IDeviceManager smartHomeController = DeviceManager.getInstance();
    private ICommandManager commandManager = CommandManager.getInstance();
    private IUserManager userManager = UserManager.getInstance();

    private RequestManager() {}

    public static RequestManager getInstance() {
        return ourInstance;
    }

    @Override
    public CommandResponseObject undoLastCommand() {
        return null;
    }

    @Override
    public String getServerrInfo() {
        return null;
    }

    @Override
    public CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        return null;
    }

    @Override
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        return null;
    }

    @Override
    public double getHeatingTemperature(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @Override
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @Override
    public CommandResponseObject moveShuttersUp(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject moveShuttersDown(UserTransferObject authentication) {
        return null;
    }

    @Override
    public String getShutterPosition(UserTransferObject authentication) {
        return null;
    }

    @Override
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @Override
    public List<ShutterTransferObject> getAllShutterData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @Override
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @Override
    public CommandResponseObject login(UserTransferObject authentication, UserTransferObject login) {
        return null;
    }

    @Override
    public CommandResponseObject logout(UserTransferObject authentication, UserTransferObject logout) {
        return null;
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @Override
    public List<UserTransferObject> getAllUserData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation) {
        return null;
    }

    @Override
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        return null;
    }

    @Override
    public double getAirHumidity(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public double getAitPressure(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public double getWindVelocity(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public double getOutdoorTemperature(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public double getRainfallAmount(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer) {
        return null;
    }

    @Override
    public CommandResponseObject deleteThermometer(UserTransferObject authentication) {
        return null;
    }

    @Override
    public double getIndoorTemperature(UserTransferObject authentication) {
        return 0;
    }

    @Override
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public String[] showLogs(UserTransferObject authentication, int limit) {
        return new String[0];
    }
}
