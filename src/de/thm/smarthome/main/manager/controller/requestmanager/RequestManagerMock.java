package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.factory.HeatingFactory;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManagerMock;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManagerMock;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManagerMock implements IServiceFacade {
    private static RequestManagerMock ourInstance = new RequestManagerMock();

    private IDeviceManager smartHomeController = DeviceManager.getInstance();
    private ICommandManager commandManager = CommandManager.getInstance();
    private IUserManager userManager = UserManagerMock.getInstance(); //UserManager.getInstance(); TODO: Change UserManager back to real one instead of Mock!
    private IDeviceManager deviceManager = DeviceManagerMock.getInstance();

    private RequestManagerMock() {}

    public static RequestManagerMock getInstance() {
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
        HeatingFactory heatingFactory = new HeatingFactory();

        return new CommandResponseObject(deviceManager.setSmartHeating(heatingFactory.createHeating(DeviceManufacturer.VIESSMANN,"V348732B328","","")));
    }

    private ResponseCode checkLogin(UserTransferObject authentication) {
        return userManager.checkLogin(authentication);
    }

    @Override
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        return new CommandResponseObject(ResponseCode.Success);
    }

    @Override
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        return new CommandResponseObject(deviceManager.getSmartHeating().switchOn());
    }

    @Override
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        return new CommandResponseObject(deviceManager.getSmartHeating().switchOff());
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
        return new HeatingTransferObject(deviceManager.getSmartHeating().getTemperature(),UnitOfMeasurement.temperature_DegreesCelsius);
    }

    @Override
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) throws RemoteException{
        ResponseCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                SmartHeating smartHeating = deviceManager.getSmartHeating();

                return new HeatingTransferObject(
                        "Vitorondens S17",
                        18
                        );
            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject moveAllShuttersUp(UserTransferObject authentication) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject moveAllShuttersDown(UserTransferObject authentication) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject moveShutterUp(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject moveShutterDown(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        return new ShutterTransferObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        return new ShutterTransferObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        return new ShutterTransferObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
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
        return new UserTransferObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
        return null;
    }

    @Override
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStationTransferObject) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
    }

    @Override
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        return new CommandResponseObject(ResponseCode.CommandInvocationFailed);
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
