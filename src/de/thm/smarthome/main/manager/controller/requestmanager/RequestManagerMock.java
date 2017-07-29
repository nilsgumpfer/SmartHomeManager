package de.thm.smarthome.main.manager.controller.requestmanager;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.*;
import de.thm.smarthome.global.interfaces.IServiceFacade;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.metadata.MetaDataManager;
import de.thm.smarthome.global.transfer.*;

/**
 * Created by Nils on 27.01.2017.
 */

public class RequestManagerMock implements IServiceFacade {
    private static RequestManagerMock ourInstance = new RequestManagerMock();

    private HeatingTransferObject heatingTransferObject =
            new HeatingTransferObject(
                    new MeasureBean(42.4, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS),
                    new MeasureBean(42.4, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS),
                    new ModelVariantBean(EModelVariant.Heizung1000),
                    new ManufacturerBean(EDeviceManufacturer.BUDERUS),
                    new ActionModeBean(EActionMode.DAYMODE),
                    "MyBuderusHeating1000",
                    "BD2967498834098",
                    new PowerStateBean(EPowerState.ON)

            );

    private RequestManagerMock() {}

    public static RequestManagerMock getInstance() {
        return ourInstance;
    }

    @Override
    public String getServerInfo() {
        return MetaDataManager.getStatus() + " @ REST-Url: " + MetaDataManager.getUrlREST();
    }

    @Override
    public MessageBean createHeating(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean deleteHeating(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean switchHeatingOn(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean switchHeatingOff(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean setHeatingTemperature(String requesting_user, double temperature) {
        heatingTransferObject.setDesiredTemperature(new MeasureBean(temperature, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));
        heatingTransferObject.setCurrentTemperature(new MeasureBean(temperature, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));

        return new MessageBean(true);
    }

    @Override
    public MeasureBean getHeatingTemperature(String requesting_user) {
        return heatingTransferObject.getCurrentTemperature();
    }

    @Override
    public HeatingTransferObject getHeatingData(String requesting_user) {
        return heatingTransferObject;
    }

    @Override
    public MessageBean createShutter(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean deleteShutter(String requesting_user, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean moveAllShuttersUp(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean moveAllShuttersDown(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean moveShutterUp(String requesting_user, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean moveShutterDown(String requesting_user, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public PositionBean getShutterPosition(String requesting_user, String serialnumber) {
        return new PositionBean(EPosition.NA);
    }

    @Override
    public MessageBean setShutterPosition(String requesting_user, String serialnumber, String position) {
        return new MessageBean(false);
    }

    @Override
    public ShutterTransferObject getShutterData(String requesting_user, String serialnumber) {
        //TODO: return new ShutterTransferObject();
        return null;
    }

    @Override
    public ShutterTransferObject[] getAllShutterData(String requesting_user) {
        //TODO: return new ShutterTransferObject[ ];
        return null;
    }

    @Override
    public MessageBean createUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean deleteUser(String requesting_user, String username) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean alterUser(String requesting_user, String username, String password, String firstname, String lastname, String email) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean login(String username, String password) {
        return new MessageBean(true);
    }

    @Override
    public MessageBean logout(String requesting_user, String username) {
        return new MessageBean(true);
    }

    @Override
    public UserTransferObject getUserData(String requesting_user, String username) {
        //TODO: return new UserTransferObject();
        return null;
    }

    @Override
    public UserTransferObject[] getAllUserData(String requesting_user) {
        //TODO: return new UserTransferObject[ ];
        return null;
    }

    @Override
    public MessageBean createWeatherStation(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean deleteWeatherStation(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MeasureBean getAirHumidity(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.RELATION_PERCENT);
    }

    @Override
    public MeasureBean getAirPressure(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.PRESSURE_BAR);
    }

    @Override
    public MeasureBean getWindVelocity(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.VELOCITY_KILOMETERSPERHOUR);
    }

    @Override
    public MeasureBean getOutdoorTemperature(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    }

    @Override
    public MeasureBean getRainfallAmount(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.VOLUME_LITRESPERSQUAREMETER);
    }

    @Override
    public WeatherStationTransferObject getWeatherStationData(String requesting_user) {
        //TODO: return new WeatherStationTransferObject();
        return null;
    }

    @Override
    public MessageBean createThermometer(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber) {
        return new MessageBean(false);
    }

    @Override
    public MessageBean deleteThermometer(String requesting_user) {
        return new MessageBean(false);
    }

    @Override
    public MeasureBean getIndoorTemperature(String requesting_user) {
        return new MeasureBean(42.4, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS);
    }

    @Override
    public ThermometerTransferObject getThermometerData(String requesting_user) {
        //TODO: return new ThermometerTransferObject();
        return null;
    }

    @Override
    public String[] readLogs(String requesting_user, int limit) {
        return SmartHomeLogger.readLogs(limit);
    }

    @Override
    public MessageBean undoLastCommand(String requesting_user) {
        return new MessageBean(false);
    }
}
