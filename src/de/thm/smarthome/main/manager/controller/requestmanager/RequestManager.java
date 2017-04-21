package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManagerMock;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManager implements IServiceFacade {
    private static RequestManager ourInstance = new RequestManager();

    private IDeviceManager smartHomeController = DeviceManager.getInstance();
    private ICommandManager commandManager = CommandManager.getInstance();
    private IUserManager userManager = UserManagerMock.getInstance(); //UserManager.getInstance(); TODO: Change UserManager back to real one instead of Mock!
    private IDeviceManager deviceManager = DeviceManager.getInstance();

    private RequestManager() {}

    public static RequestManager getInstance() {
        return ourInstance;
    }

    @Override
    public CommandResponseObject undoLastCommand(UserTransferObject authentication) {
        return new CommandResponseObject(commandManager.undoLastCommand());
    }

    @Override
    public String getMessage(ResponseCode responseCode) {
        return MessageRepository.getMessage(responseCode);
    }

    @Override
    public String getServerInfo() {
        //TODO: provide some information about current state, connected devices, ip, and so on as simple text-message
        String version = "0.1";
        String ip = "127.0.0.1";
        String wsurl = "http://" + ip + ":8080/SmartHomeManagerWebServices";

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
                return new CommandResponseObject(commandManager.addSwitchOnCommand(deviceManager.getSmartHeating()));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addSwitchOffCommand(deviceManager.getSmartHeating()));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addSetTemperatureCommand(deviceManager.getSmartHeating(), temperature));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingTemperature(UserTransferObject authentication) throws RemoteException{
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new HeatingTransferObject(deviceManager.getSmartHeating().getTemperature(), UnitOfMeasurement.temperature_DegreesCelsius);
            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) throws RemoteException{
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                SmartHeating smartHeating = deviceManager.getSmartHeating();

                /**-->soll von der Heizung als Methode zurückgegeben werden (wie bei shutter, etc.)**/
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
    public CommandResponseObject moveAllShuttersUp(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addMoveUpCommand());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject moveAllShuttersDown(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addMoveDownCommand());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject moveShutterUp(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addMoveUpCommand(shutterTransferObject));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject moveShutterDown(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(commandManager.addMoveDownCommand(shutterTransferObject));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new ShutterTransferObject(deviceManager.getSmartShutter(shutterTransferObject).getPosition());
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new ShutterTransferObject(deviceManager.getSmartShutter(shutterTransferObject).setPosition(shutterTransferObject));
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return deviceManager.getSmartShutter(shutterTransferObject).getShutterData();
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);
        List<ShutterTransferObject> shutterTransferObjects = new ArrayList<>();
        ShutterTransferObject [] array = {};

        if(responseCode == ResponseCode.LoggedIn)
            for (SmartShutter smartShutter : deviceManager.getSmartShutters()) {
                shutterTransferObjects.add(smartShutter.getShutterData());
            }

        return shutterTransferObjects.toArray(array);
    }

    @Override
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.createUser(userTransferObject);
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.deleteUser(userTransferObject);
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.alterUser(userTransferObject);
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject login(UserTransferObject userTransferObject) {
        return new CommandResponseObject(userManager.login(userTransferObject));
    }

    @Override
    public CommandResponseObject logout(UserTransferObject authentication, UserTransferObject userTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(userManager.logout(userTransferObject));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject userTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.getUserData(userTransferObject);
            default:
                return new UserTransferObject(responseCode);
        }
    }

    @Override
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);
        UserTransferObject[] array = {};

        switch(responseCode){
            case LoggedIn:
                return userManager.getAllUserData();
            default:
                return array;
        }
    }

    @Override
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStationTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.createSmartWeatherStation(weatherStationTransferObject));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.deleteSmartWeatherStation());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public WeatherStationTransferObject getAirHumidity(UserTransferObject authentication) {
        return getWeatherStationData(authentication);
    }

    private WeatherStationTransferObject getWeatherStationData() {
        return deviceManager.getSmartWeatherStation().getWeatherStationData();
    }

    @Override
    public WeatherStationTransferObject getAirPressure(UserTransferObject authentication) {
        return getWeatherStationData(authentication);
    }

    @Override
    public WeatherStationTransferObject getWindVelocity(UserTransferObject authentication) {
        return getWeatherStationData(authentication);
    }

    @Override
    public WeatherStationTransferObject getOutdoorTemperature(UserTransferObject authentication) {
        return getWeatherStationData(authentication);
    }

    @Override
    public WeatherStationTransferObject getRainfallAmount(UserTransferObject authentication) {
        return getWeatherStationData(authentication);
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return getWeatherStationData();
            default:
                return new WeatherStationTransferObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometerTransferObject) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.createSmartThermometer(thermometerTransferObject));
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject deleteThermometer(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new CommandResponseObject(deviceManager.deleteSmartThermometer());
            default:
                return new CommandResponseObject(responseCode);
        }
    }

    @Override
    public ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication) {
        return getThermometerData(authentication);
    }

    @Override
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return getThermometerData();
            default:
                return new ThermometerTransferObject(responseCode);
        }
    }

    public ThermometerTransferObject getThermometerData() {
        return deviceManager.getSmartThermometer().getThermometerData();
    }

    @Override
    public String[] readLogs(UserTransferObject authentication, int limit) {
        return SmartHomeLogger.readLogs(limit);
    }
}
