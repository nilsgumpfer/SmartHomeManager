package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EPosition;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.metadata.MetaDataManager;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;
import de.thm.smarthome.main.manager.controller.commandmanager.ICommandManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.usermanager.IUserManager;
import de.thm.smarthome.main.manager.controller.usermanager.UserManagerMock;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManager implements IServiceFacade {
    private static RequestManager ourInstance = new RequestManager();

    private ICommandManager commandManager = CommandManager.getInstance();
    private IUserManager userManager = UserManagerMock.getInstance(); //UserManager.getInstance(); TODO: Change UserManager back to real one instead of Mock!
    private IDeviceManager deviceManager = DeviceManager.getInstance();

    private RequestManager() {}

    public static RequestManager getInstance() {
        return ourInstance;
    }

    @Override
    public String getServerInfo() {
        return MetaDataManager.getHostInfo();
    }

    @Override
    public MessageBean createHeating(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.createSmartHeating(modelVariant, manufacturer, genericName, serialnumber);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean deleteHeating(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.deleteSmartHeating();
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean switchHeatingOn(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addSwitchOnCommand(deviceManager.getSmartHeating());
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean switchHeatingOff(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addSwitchOffCommand(deviceManager.getSmartHeating());
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean setHeatingTemperature(String requesting_user, double temperature) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addSetTemperatureCommand(deviceManager.getSmartHeating(),new MeasureBean(temperature, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));
        else
            return new MessageBean(false);
    }

    @Override
    public MeasureBean getHeatingTemperature(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartHeating().getCurrentTemperature();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public HeatingTransferObject getHeatingData(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartHeating().getHeatingData();
        else
            return TransferObjectFactory.getEmptyHeatingTransferObject();
    }

    @Override
    public MessageBean createShutter(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.createSmartShutter(modelVariant, manufacturer, genericName, serialnumber);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean deleteShutter(String requesting_user, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.deleteSmartShutter(deviceManager.getSmartShutter(serialnumber));
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean moveAllShuttersUp(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addMoveUpCommand();
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean moveAllShuttersDown(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addMoveDownCommand();
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean moveShutterUp(String requesting_user, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addMoveUpCommand(deviceManager.getSmartShutter(serialnumber));
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean moveShutterDown(String requesting_user, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.addMoveDownCommand(deviceManager.getSmartShutter(serialnumber));
        else
            return new MessageBean(false);
    }

    @Override
    public PositionBean getShutterPosition(String requesting_user, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartShutter(serialnumber).getCurrentPosition();
        else
            return new PositionBean(EPosition.NA);
    }

    @Override
    public MessageBean setShutterPosition(String requesting_user, String serialnumber, String position) {
        if(userManager.isLoggedIn(requesting_user)) {
            try
            {
                PositionBean positionBean = new PositionBean(Integer.parseInt(position));
                return commandManager.addSetPositionCommand(deviceManager.getSmartShutter(serialnumber), positionBean);
            }
            catch (Exception e)
            {
                SmartHomeLogger.log(e);
                return new MessageBean(false);
            }
        }
        else
            return new MessageBean(false);
    }

    @Override
    public ShutterTransferObject getShutterData(String requesting_user, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartShutter(serialnumber).getShutterData();
        else
            return TransferObjectFactory.getEmptyShutterTransferObject();
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user)) {
            List<SmartShutter> smartShutterList = deviceManager.getSmartShutters();
            return (ShutterTransferObject[]) smartShutterList.toArray();
        }
        else
            return TransferObjectFactory.getEmptyShutterTransferObjects();
    }

    @Override
    public MessageBean createUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.createUser(username, password, firstname, lastname, email);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean deleteUser(String requesting_user, String username) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.deleteUser(username);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean alterUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.alterUser(username, password, firstname, lastname, email);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean login(String username, String password) {
        return userManager.login(username, password);
    }

    @Override
    public MessageBean logout(String requesting_user, String username) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.logout(username);
        else
            return new MessageBean(false);
    }

    @Override
    public UserTransferObject getUserData(String requesting_user, String username) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.getUserData(username);
        else
            return TransferObjectFactory.getEmptyUserTransferObject();
    }

    @Override
    public UserTransferObject[] getAllUserData(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return userManager.getAllUserData();
        else
            return TransferObjectFactory.getEmptyUserTransferObjects();
    }

    @Override
    public MessageBean createWeatherStation(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.createSmartWeatherStation(modelVariant, manufacturer, genericName, serialnumber);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean deleteWeatherStation(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.deleteSmartWeatherStation();
        else
            return new MessageBean(false);
    }

    @Override
    public MeasureBean getAirHumidity(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getAirHumidity();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getAirPressure(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getAirPressure();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getWindVelocity(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getWindVelocity();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getOutdoorTemperature(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getTemperature();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getRainfallAmount(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getRainfallAmount();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartWeatherStation().getWeatherStationData();
        else
            return TransferObjectFactory.getEmptyWeatherStationTransferObject();
    }

    @Override
    public MessageBean createThermometer(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.createSmartThermometer(modelVariant, manufacturer, genericName, serialnumber);
        else
            return new MessageBean(false);
    }

    @Override
    public MessageBean deleteThermometer(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.deleteSmartThermometer();
        else
            return new MessageBean(false);
    }

    @Override
    public MeasureBean getIndoorTemperature(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartThermometer().getTemperature();
        else
            return new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }

    @Override
    public ThermometerTransferObject getThermometerData(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return deviceManager.getSmartThermometer().getThermometerData();
        else
            return TransferObjectFactory.getEmptyThermometerTransferObject();
    }

    @Override
    public String[] readLogs(String requesting_user, int limit) {
        if(userManager.isLoggedIn(requesting_user))
            return SmartHomeLogger.readLogs(limit);
        else
            return new String[] {"N/A"};
    }

    @Override
    public MessageBean undoLastCommand(String requesting_user) {
        if(userManager.isLoggedIn(requesting_user))
            return commandManager.undoLastCommand();
        else
            return new MessageBean(false);
    }
}
