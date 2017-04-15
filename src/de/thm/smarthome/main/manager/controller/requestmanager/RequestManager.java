package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManager;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManager implements IServiceFacade {
    private static RequestManager ourInstance = new RequestManager();

    private IDeviceManager smartHomeController = DeviceManager.getInstance();
    private ICommandManager commandManager = CommandManager.getInstance();
    private IUserManager userManager = UserManager.getInstance();
    private IDeviceManager deviceManager = DeviceManager.getInstance();

    private RequestManager() {}

    public static RequestManager getInstance() {
        return ourInstance;
    }

    @Override
    public CommandResponseObject undoLastCommand() {
        return new CommandResponseObject(commandManager.undoLastCommand());
    }

    @Override
    public String getServerInfo() {
        //TODO: provide some information about current state, connected devices, ip, and so on as simple text-message
        String version = "0.1";
        String ip = "127.0.0.1";
        String wsurl = "http://" + ip + ":8080/services";

        return "SmartHomeManager Version " + version + "\nServer-IP: " + ip +"\nWebService-URL: " + wsurl + "\netc. ...";
    }

    @Override
    public CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.createSmartHeating(heating));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    private ResponseCode checkLogin(UserTransferObject authentication) {
        return userManager.checkLogin(authentication);
    }

    @Override
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.deleteSmartHeating());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.getSmartHeating().switchOn());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.getSmartHeating().switchOff());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.getSmartHeating().setTemperature(temperature));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingTemperature(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new HeatingTransferObject(deviceManager.getSmartHeating().getTemperature());
            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                SmartHeating smartHeating = deviceManager.getSmartHeating();

                return new HeatingTransferObject(
                        smartHeating.getName(),
                        smartHeating.getTemperature()
                        );
            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.createSmartShutter(shutter));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.deleteSmartShuttter(shutter));
            default:
                return new CommandResponseObject(responseCode);
        }
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
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
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
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
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
    public WeatherStationTransferObject getAirHumidity(UserTransferObject authentication) {
        return null;
    }

    @Override
    public WeatherStationTransferObject getAirPressure(UserTransferObject authentication) {
        return null;
    }

    @Override
    public WeatherStationTransferObject getWindVelocity(UserTransferObject authentication) {
        return null;
    }

    @Override
    public WeatherStationTransferObject getOutdoorTemperature(UserTransferObject authentication) {
        return null;
    }

    @Override
    public WeatherStationTransferObject getRainfallAmount(UserTransferObject authentication) {
        return null;
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
    public ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication) {
        return null;
    }

    @Override
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public String[] readLogs(UserTransferObject authentication, int limit) {
        return new String[0];
    }
}
