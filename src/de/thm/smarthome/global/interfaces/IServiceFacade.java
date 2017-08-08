package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.transfer.*;

/**
 * Created by Nils on 04.02.2017.
 */
public interface IServiceFacade {
    String getServerInfo();

    MessageBean createHeating(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber);
    MessageBean deleteHeating(String requesting_user);
    MessageBean switchHeatingOn(String requesting_user);
    MessageBean switchHeatingOff(String requesting_user);
    MessageBean setHeatingTemperature(String requesting_user, double temperature);
    MeasureBean getHeatingTemperature(String requesting_user);
    HeatingTransferObject getHeatingData(String requesting_user);

    MessageBean createShutter(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber);
    MessageBean deleteShutter(String requesting_user, String serialnumber);
    MessageBean moveAllShuttersUp(String requesting_user);
    MessageBean moveAllShuttersDown(String requesting_user);
    MessageBean moveShutterUp(String requesting_user, String serialnumber);
    MessageBean moveShutterDown(String requesting_user, String serialnumber);
    PositionBean getShutterPosition(String requesting_user, String serialnumber);
    MessageBean setShutterPosition(String requesting_user, String serialnumber, String position);
    ShutterTransferObject getShutterData(String requesting_user, String serialnumber);
    ShutterTransferObject[] getAllShutterData(String requesting_user);

    MessageBean createUser(String requesting_user, String username, String password, String firstname, String lastname, String email);
    MessageBean deleteUser(String requesting_user, String username);
    MessageBean alterUser(String requesting_user, String username, String password, String firstname, String lastname, String email);
    MessageBean login(String username, String password);
    MessageBean logout(String requesting_user, String username);
    UserTransferObject getUserData(String requesting_user, String username);
    UserTransferObject[] getAllUserData(String requesting_user);

    MessageBean createWeatherStation(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber);
    MessageBean deleteWeatherStation(String requesting_user);
    MeasureBean getAirHumidity(String requesting_user);
    MeasureBean getAirPressure(String requesting_user);
    MeasureBean getWindVelocity(String requesting_user);
    MeasureBean getOutdoorTemperature(String requesting_user);
    MeasureBean getRainfallAmount(String requesting_user);
    WeatherStationTransferObject getWeatherStationData(String requesting_user);

    MessageBean createThermometer(String requesting_user, String modelVariant, String manufacturer, String genericName, String serialnumber);
    MessageBean deleteThermometer(String requesting_user);
    MeasureBean getIndoorTemperature(String requesting_user);
    ThermometerTransferObject getThermometerData(String requesting_user);

    String[] readLogs(String requesting_user, int limit);

    MessageBean undoLastCommand(String requesting_user);

    String[] getHeatingManufacturers_static();
    String[] getShutterManufacturers_static();
    String[] getThermometerManufacturers_static();
    String[] getWeatherStationManufacturers_static();

    String[] getHeatingModelVariants_static();
    String[] getThermometerModelVariants_static();
    String[] getWeatherStationModelVariants_static();
    String[] getShutterModelVariants_static();
    String[] getShutterPositions_static();


}
