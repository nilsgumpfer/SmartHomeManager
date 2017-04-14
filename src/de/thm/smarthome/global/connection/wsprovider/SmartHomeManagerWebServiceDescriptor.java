package de.thm.smarthome.global.connection.wsprovider;

import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.manager.controller.requestmanager.RequestManager;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService(name="SmartHomeManagerWebServices")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SmartHomeManagerWebServiceDescriptor implements IServiceFacade
{
    private IServiceFacade requestManager = RequestManager.getInstance();

    public SmartHomeManagerWebServiceDescriptor(){
    }

    @WebMethod
    public String getServerInfo() {
        return requestManager.getServerInfo();
    }

    @WebMethod
    public CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        return requestManager.createHeating(authentication,heating);
    }

    @WebMethod
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        return requestManager.deleteHeating(authentication);
    }

    @WebMethod
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        return  requestManager.switchHeatingOn(authentication);
    }

    @WebMethod
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        return requestManager.switchHeatingOff(authentication);
    }

    @WebMethod
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        return requestManager.setHeatingTemperature(authentication,temperature);
    }

    @WebMethod
    public HeatingTransferObject getHeatingTemperature(UserTransferObject authentication) {
        return requestManager.getHeatingTemperature(authentication);
    }

    @WebMethod
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) {
        return requestManager.getHeatingData(authentication);
    }

    @WebMethod
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return requestManager.createShutter(authentication, shutter);
    }

    @WebMethod
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return requestManager.deleteShutter(authentication, shutter);
    }

    @WebMethod
    public CommandResponseObject moveShuttersUp(UserTransferObject authentication) {
        return requestManager.moveShuttersUp(authentication);
    }

    @WebMethod
    public CommandResponseObject moveShuttersDown(UserTransferObject authentication) {
        return requestManager.moveShuttersDown(authentication);
    }

    @WebMethod
    public String getShutterPosition(UserTransferObject authentication) {
        return requestManager.getShutterPosition(authentication);
    }

    @WebMethod
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter) {
        return requestManager.getShutterData(authentication, shutter);
    }

    @WebMethod
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
        return requestManager.getAllShutterData(authentication);
    }

    @WebMethod
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.createUser(authentication, user);
    }

    @WebMethod
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.deleteUser(authentication,user);
    }

    @WebMethod
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.alterUser(authentication,user);
    }

    @WebMethod
    public CommandResponseObject login(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.login(authentication,user);
    }

    @WebMethod
    public CommandResponseObject logout(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.logout(authentication, user);
    }

    @WebMethod
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user) {
        return requestManager.getUserData(authentication, user);
    }

    @WebMethod
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
        return requestManager.getAllUserData(authentication);
    }

    @WebMethod
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation) {
        return createWeatherStation(authentication, weatherStation);
    }

    @WebMethod
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        return requestManager.deleteWeatherStation(authentication);
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

    @WebMethod
    public WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication) {
        return requestManager.getWeatherStationData(authentication);
    }

    @WebMethod
    public CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer) {
        return requestManager.createThermometer(authentication,thermometer);
    }

    @WebMethod
    public CommandResponseObject deleteThermometer(UserTransferObject authentication) {
        return requestManager.deleteThermometer(authentication);
    }

    @Override
    public ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        return requestManager.getThermometerData(authentication);
    }

    @WebMethod
    public String[] readLogs(UserTransferObject authentication, int limit) {
        return requestManager.readLogs(authentication, limit);
    }

    @WebMethod
    public CommandResponseObject undoLastCommand() {
        return requestManager.undoLastCommand();
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