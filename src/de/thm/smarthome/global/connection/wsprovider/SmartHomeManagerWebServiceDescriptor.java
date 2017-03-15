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
        this.requestManager = RequestManager.getInstance();
    }

    @WebMethod
    public String getServerInfo() {
        return null;
    }

    @WebMethod
    public String getServerrInfo() {
        return null;
    }

    @WebMethod
    public CommandResponseObject createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        return null;
    }

    @WebMethod
    public CommandResponseObject deleteHeating(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject switchHeatingOn(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject switchHeatingOff(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject setHeatingTemperature(UserTransferObject authentication, double temperature) {
        return null;
    }

    @WebMethod
    public double getHeatingTemperature(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public HeatingTransferObject getHeatingData(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @WebMethod
    public CommandResponseObject deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @WebMethod
    public CommandResponseObject moveShuttersUp(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject moveShuttersDown(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public String getShutterPosition(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutter) {
        return null;
    }

    @WebMethod
    public List<ShutterTransferObject> getAllShutterData(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject createUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @WebMethod
    public CommandResponseObject deleteUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @WebMethod
    public CommandResponseObject alterUser(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @WebMethod
    public CommandResponseObject login(UserTransferObject authentication, UserTransferObject login) {
        return null;
    }

    @WebMethod
    public CommandResponseObject logout(UserTransferObject authentication, UserTransferObject logout) {
        return null;
    }

    @WebMethod
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject user) {
        return null;
    }

    @WebMethod
    public List<UserTransferObject> getAllUserData(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStation) {
        return null;
    }

    @WebMethod
    public CommandResponseObject deleteWeatherStation(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public double getAirHumidity(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public double getAitPressure(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public double getWindVelocity(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public double getOutdoorTemperature(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public double getRainfallAmount(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public WeatherStationTransferObject getWeatherStationData(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public CommandResponseObject createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometer) {
        return null;
    }

    @WebMethod
    public CommandResponseObject deleteThermometer(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public double getIndoorTemperature(UserTransferObject authentication) {
        return 0;
    }

    @WebMethod
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        return null;
    }

    @WebMethod
    public String[] showLogs(UserTransferObject authentication, int limit) {
        return new String[0];
    }

    @Override
    public CommandResponseObject undoLastCommand() {
        return null;
    }

    /*@WebMethod(operationName="body-mass-index")
    @WebResult(name = "your-bmi")
    public double bmi( @WebParam(name="height") double height,
                       @WebParam(name="weight") double weight )
    {
        return weight / ((height * height) / 10000);
    }*/
}