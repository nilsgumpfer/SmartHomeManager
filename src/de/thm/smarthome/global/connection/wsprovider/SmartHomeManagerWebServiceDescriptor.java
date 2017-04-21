package de.thm.smarthome.global.connection.wsprovider;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.IHeatingObserver;
import de.thm.smarthome.global.observer.IShutterObserver;
import de.thm.smarthome.global.observer.IThermometerObserver;
import de.thm.smarthome.global.observer.IWeatherstationObserver;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.manager.controller.requestmanager.RequestManager;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import java.rmi.RemoteException;

@WebService(name="SmartHomeManagerWebServices")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SmartHomeManagerWebServiceDescriptor implements IServiceFacade
{
    private IServiceFacade requestManager = RequestManager.getInstance();

    public SmartHomeManagerWebServiceDescriptor(){
    }

    @WebMethod
    public String getServerInfo() {
        SmartHomeLogger.log("WSD " + "getServerInfo()");
        return requestManager.getServerInfo();
    }

    @WebMethod
    public CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        SmartHomeLogger.log("WSD " + "createHeating(" + authentication + "," + heating + ")");
        return requestManager.createHeating(authentication,heating);
    }

    @WebMethod
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "deleteHeating(" + authentication + ")");
        return requestManager.deleteHeating(authentication);
    }

    @WebMethod
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "switchHeatingOn(" + authentication + ")");
        return  requestManager.switchHeatingOn(authentication);
    }

    @WebMethod
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "switchHeatingOff(" + authentication + ")");
        return requestManager.switchHeatingOff(authentication);
    }

    @WebMethod
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        SmartHomeLogger.log("WSD " + "setHeatingTemperature(" + authentication + "," + temperature + ")");
        return requestManager.setHeatingTemperature(authentication,temperature);
    }

    @WebMethod
    public HeatingTransferObject getHeatingTemperature(UserTransferObject authentication) throws RemoteException{
        SmartHomeLogger.log("WSD " + "getHeatingTemperature(" + authentication + ")");
        return requestManager.getHeatingTemperature(authentication);
    }

    @WebMethod
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) throws RemoteException{
        SmartHomeLogger.log("WSD " + "getHeatingData(" + authentication + ")");
        return requestManager.getHeatingData(authentication);
    }

    @WebMethod
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        SmartHomeLogger.log("WSD " + "createShutter(" + authentication + "," + shutter + ")");
        return requestManager.createShutter(authentication, shutter);
    }

    @WebMethod
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        SmartHomeLogger.log("WSD " + "deleteShutter(" + authentication + "," + shutter + ")");
        return requestManager.deleteShutter(authentication, shutter);
    }

    @WebMethod
    public CommandResponseObject moveAllShuttersUp(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "moveAllShuttersUp(" + authentication + ")");
        return requestManager.moveAllShuttersUp(authentication);
    }

    @WebMethod
    public CommandResponseObject moveAllShuttersDown(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "moveAllShuttersDown(" + authentication + ")");
        return requestManager.moveAllShuttersDown(authentication);
    }

    @WebMethod
    public CommandResponseObject moveShutterUp(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        SmartHomeLogger.log("WSD " + "moveShutterUp(" + authentication + "," + shutterTransferObject + ")");
        return requestManager.moveShutterUp(authentication, shutterTransferObject);
    }

    @WebMethod
    public CommandResponseObject moveShutterDown(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        SmartHomeLogger.log("WSD " + "moveShutterDown(" + authentication + "," + shutterTransferObject + ")");
        return requestManager.moveShutterDown(authentication, shutterTransferObject);
    }

    @WebMethod
    public ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        SmartHomeLogger.log("WSD " + "getShutterPosition(" + authentication + "," + shutterTransferObject + ")");
        return requestManager.getShutterPosition(authentication,shutterTransferObject);
    }

    @WebMethod
    public ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        SmartHomeLogger.log("WSD " + "setShutterPosition(" + authentication + "," + shutterTransferObject + ")");
        return requestManager.setShutterPosition(authentication,shutterTransferObject);
    }

    @WebMethod
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter) {
        SmartHomeLogger.log("WSD " + "getShutterData(" + authentication + "," + shutter + ")");
        return requestManager.getShutterData(authentication, shutter);
    }

    @WebMethod
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getAllShutterData(" + authentication + ")");
        return requestManager.getAllShutterData(authentication);
    }

    @WebMethod
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "createUser(" + authentication + "," + user + ")");
        return requestManager.createUser(authentication, user);
    }

    @WebMethod
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "deleteUser(" + authentication + "," + user + ")");
        return requestManager.deleteUser(authentication,user);
    }

    @WebMethod
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "alterUser(" + authentication + "," + user + ")");
        return requestManager.alterUser(authentication,user);
    }

    @WebMethod
    public CommandResponseObject login(UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "login(" + user + ")");
        return requestManager.login(user);
    }

    @WebMethod
    public CommandResponseObject logout(UserTransferObject authentication, UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "logout(" + authentication + "," + user + ")");
        return requestManager.logout(authentication, user);
    }

    @WebMethod
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user) {
        SmartHomeLogger.log("WSD " + "getUserData(" + authentication + "," + user + ")");
        return requestManager.getUserData(authentication, user);
    }

    @WebMethod
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getAllUserData(" + authentication + ")");
        return requestManager.getAllUserData(authentication);
    }

    @WebMethod
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation) {
        SmartHomeLogger.log("WSD " + "createWeatherStation(" + authentication + "," + weatherStation + ")");
        return requestManager.createWeatherStation(authentication, weatherStation);
    }

    @WebMethod
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "deleteWeatherStation(" + authentication + ")");
        return requestManager.deleteWeatherStation(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getAirHumidity(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getAirHumidity(" + authentication + ")");
        return requestManager.getAirHumidity(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getAirPressure(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getAirPressure(" + authentication + ")");
        return requestManager.getAirPressure(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getWindVelocity(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getWindVelocity(" + authentication + ")");
        return requestManager.getWindVelocity(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getOutdoorTemperature(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getOutdoorTemperature(" + authentication + ")");
        return requestManager.getOutdoorTemperature(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getRainfallAmount(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getRainfallAmount(" + authentication + ")");
        return requestManager.getRainfallAmount(authentication);
    }

    @WebMethod
    public WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getWeatherStationData(" + authentication + ")");
        return requestManager.getWeatherStationData(authentication);
    }

    @WebMethod
    public CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer) {
        SmartHomeLogger.log("WSD " + "createThermometer(" + authentication + "," + thermometer + ")");
        return requestManager.createThermometer(authentication,thermometer);
    }

    @WebMethod
    public CommandResponseObject deleteThermometer(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "deleteThermometer(" + authentication + ")");
        return requestManager.deleteThermometer(authentication);
    }

    @WebMethod
    public ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getIndoorTemperature(" + authentication + ")");
        return requestManager.getIndoorTemperature(authentication);
    }

    @WebMethod
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "getThermometerData(" + authentication + ")");
        return requestManager.getThermometerData(authentication);
    }

    @WebMethod
    public String[] readLogs(UserTransferObject authentication, int limit) {
        SmartHomeLogger.log("WSD " + "readLogs(" + authentication + "," + " limit: " + limit + ")");
        return requestManager.readLogs(authentication, limit);
    }

    @WebMethod
    public CommandResponseObject undoLastCommand(UserTransferObject authentication) {
        SmartHomeLogger.log("WSD " + "undoLastCommand(" + authentication + ")");
        return requestManager.undoLastCommand(authentication);
    }

    @WebMethod
    public String getMessage(ResponseCode responseCode) {
        return requestManager.getMessage(responseCode);
    }

    /*
    //Web-Service-Test-Szenario (Nils)
    @WebMethod(operationName="body-mass-index")
    @WebResult(name = "your-bmi")
    public double bmi( @WebParam(name="height") double height,
                       @WebParam(name="weight") double weight )
    {
        return weight / ((height * height) / 10000);
    }*/
}