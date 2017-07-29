package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManagerMock;

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
    public String getServerInfo() {
        return null;
    }

    @Override
    public MessageBean createHeating(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean deleteHeating(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean switchHeatingOn(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean switchHeatingOff(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean setHeatingTemperature(String requesting_user, double temperature) {
        return null;
    }

    @Override
    public MeasureBean getHeatingTemperature(String requesting_user) {
        return null;
    }

    @Override
    public HeatingTransferObject getHeatingData(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean createShutter(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean deleteShutter(String requesting_user, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean moveAllShuttersUp(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean moveAllShuttersDown(String requesting_user) {
        return null;
    }

    @Override
    public MessageBean moveShutterUp(String requesting_user, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean moveShutterDown(String requesting_user, String serialnumber) {
        return null;
    }

    @Override
    public PositionBean getShutterPosition(String requesting_user, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean setShutterPosition(String requesting_user, String serialnumber, String position) {
        return null;
    }

    @Override
    public ShutterTransferObject getShutterData(String requesting_user, String serialnumber) {
        return null;
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(String requesting_user) {
        return new ShutterTransferObject[0];
    }

    @Override
    public MessageBean createUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        return null;
    }

    @Override
    public MessageBean deleteUser(String requesting_user, String username) {
        return null;
    }

    @Override
    public MessageBean alterUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        return null;
    }

    @Override
    public MessageBean login(String username, String password) {
        return null;
    }

    @Override
    public MessageBean logout(String requesting_user, String username) {
        return null;
    }

    @Override
    public UserTransferObject getUserData(String requesting_user, String username) {
        return null;
    }

    @Override
    public UserTransferObject[] getAllUserData(String requesting_user) {
        return new UserTransferObject[0];
    }

    @Override
    public MessageBean createWeatherStation(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean deleteWeatherStation(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getAirHumidity(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getAirPressure(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getWindVelocity(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getOutdoorTemperature(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getRainfallAmount(String requesting_user) {
        return null;
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData(String requesting_user) {
        return deviceManager.getSmartWeatherStation().getWeatherStationData();
    }

    @Override
    public MessageBean createThermometer(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return null;
    }

    @Override
    public MessageBean deleteThermometer(String requesting_user) {
        return null;
    }

    @Override
    public MeasureBean getIndoorTemperature(String requesting_user) {
        return null;
    }

    @Override
    public ThermometerTransferObject getThermometerData(String requesting_user) {
        return null;
    }

    @Override
    public String[] readLogs(String requesting_user, int limit) {
        return new String[0];
    }

    @Override
    public MessageBean undoLastCommand(String requesting_user) {
        return null;
    }

    /*
    @Override
    public MessageBean undoLastCommand(String requesting_user) {
        MessageBean check = userManager.checkLogin(requesting_user);

        if(check.getMessageCode_Enum() == EMessageCode.LOGGEDIN)
            return commandManager.undoLastCommand();
        else
            return check;

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
    public MessageBean createHeating(UserTransferObject authentication, HeatingTransferObject heating) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.createSmartHeating(heating));
            default:
                return new MessageBean(responseCode);
        }
    }

    private EMessageCode checkLogin(UserTransferObject authentication) {
        return userManager.checkLogin(authentication);
    }

    @Override
    public MessageBean deleteHeating(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.deleteSmartHeating());
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean switchHeatingOn(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addSwitchOnCommand(deviceManager.getSmartHeating()));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean switchHeatingOff(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addSwitchOffCommand(deviceManager.getSmartHeating()));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean setHeatingTemperature(UserTransferObject authentication, double temperature) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addSetTemperatureCommand(deviceManager.getSmartHeating(), temperature));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingTemperature(UserTransferObject authentication){
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new HeatingTransferObject(deviceManager.getSmartHeating().getTemperature(), EUnitOfMeasurement.temperature_DegreesCelsius);
            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public HeatingTransferObject getHeatingData(UserTransferObject authentication){
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                SmartHeating smartHeating = deviceManager.getSmartHeating();

                ///-->soll von der Heizung als Methode zurückgegeben werden (wie bei shutter, etc.)
                return smartHeating.getHeatingData();

            default:
                return new HeatingTransferObject(responseCode);
        }
    }

    @Override
    public MessageBean createShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.createSmartShutter(shutter));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean deleteShutter(UserTransferObject authentication, ShutterTransferObject shutter) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.deleteSmartShutter(shutter));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean moveAllShuttersUp(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addMoveUpCommand());
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean moveAllShuttersDown(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addMoveDownCommand());
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean moveShutterUp(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addMoveUpCommand(shutterTransferObject));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean moveShutterDown(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(commandManager.addMoveDownCommand(shutterTransferObject));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public ShutterTransferObject getShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new ShutterTransferObject(deviceManager.getSmartShutter(shutterTransferObject).getPosition());
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject setShutterPosition(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new ShutterTransferObject(deviceManager.getSmartShutter(shutterTransferObject).setPosition(shutterTransferObject));
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject getShutterData(UserTransferObject authentication, ShutterTransferObject shutterTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return deviceManager.getSmartShutter(shutterTransferObject).getShutterData();
            default:
                return new ShutterTransferObject(responseCode);
        }
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);
        List<ShutterTransferObject> shutterTransferObjects = new ArrayList<>();
        ShutterTransferObject [] array = {};

        if(responseCode == EMessageCode.LoggedIn)
            for (SmartShutter smartShutter : deviceManager.getSmartShutters()) {
                shutterTransferObjects.add(smartShutter.getShutterData());
            }

        return shutterTransferObjects.toArray(array);
    }

    @Override
    public MessageBean createUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.createUser(userTransferObject);
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean deleteUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.deleteUser(userTransferObject);
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean alterUser(UserTransferObject authentication, UserTransferObject userTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.alterUser(userTransferObject);
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean login(UserTransferObject userTransferObject) {
        return new MessageBean(userManager.login(userTransferObject));
    }

    @Override
    public MessageBean logout(UserTransferObject authentication, UserTransferObject userTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(userManager.logout(userTransferObject));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject authentication, UserTransferObject userTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return userManager.getUserData(userTransferObject);
            default:
                return new UserTransferObject(responseCode);
        }
    }

    @Override
    public UserTransferObject[] getAllUserData(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);
        UserTransferObject[] array = {};

        switch(responseCode){
            case LoggedIn:
                return userManager.getAllUserData();
            default:
                return array;
        }
    }

    @Override
    public MessageBean createWeatherStation(UserTransferObject authentication, WeatherStationTransferObject weatherStationTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.createSmartWeatherStation(weatherStationTransferObject));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean deleteWeatherStation(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.deleteSmartWeatherStation());
            default:
                return new MessageBean(responseCode);
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
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return getWeatherStationData();
            default:
                return new WeatherStationTransferObject(responseCode);
        }
    }

    @Override
    public MessageBean createThermometer(UserTransferObject authentication, ThermometerTransferObject thermometerTransferObject) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.createSmartThermometer(thermometerTransferObject));
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public MessageBean deleteThermometer(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

        switch(responseCode){
            case LoggedIn:
                return new MessageBean(deviceManager.deleteSmartThermometer());
            default:
                return new MessageBean(responseCode);
        }
    }

    @Override
    public ThermometerTransferObject getIndoorTemperature(UserTransferObject authentication) {
        return getThermometerData(authentication);
    }

    @Override
    public ThermometerTransferObject getThermometerData(UserTransferObject authentication) {
        EMessageCode responseCode = checkLogin(authentication);

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
    */
}
