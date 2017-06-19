package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.global.transfer.WeatherStationTransferObject;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 12.06.2017.
 */
public class TransferObjectFactory {
    public static HeatingTransferObject getHeatingTransferObject(IHeatingModel heatingModel)
    {
        return new HeatingTransferObject(
                                            heatingModel.getCurrentTemperature(),
                                            heatingModel.getDesiredTemperature(),
                                            heatingModel.getModelVariant(),
                                            heatingModel.getManufacturer(),
                                            heatingModel.getActionMode(),
                                            heatingModel.getGenericName(),
                                            heatingModel.getSerialnumber(),
                                            heatingModel.getPowerState()
                                        );
    }

    public static HeatingTransferObject getHeatingTransferObject(IHeatingModel heatingModel, EMessageCode messageCode)
    {
        HeatingTransferObject heatingTransferObject = getHeatingTransferObject(heatingModel);
        heatingTransferObject.setMessage(new MessageBean(messageCode));

        return heatingTransferObject;
    }

    public static ShutterTransferObject getShutterTransferObject(IShutterModel shutterModel)
    {
        return new ShutterTransferObject(
                                            shutterModel.getCurrentPosition(),
                                            shutterModel.getDesiredPosition(),
                                            shutterModel.getModelVariant(),
                                            shutterModel.getManufacturer(),
                                            shutterModel.getActionMode(),
                                            shutterModel.getGenericName(),
                                            shutterModel.getSerialnumber()
                                        );
    }

    public static ShutterTransferObject getShutterTransferObject(IShutterModel shutterModel, EMessageCode messageCode)
    {
        ShutterTransferObject shutterTransferObject = getShutterTransferObject(shutterModel);
        shutterTransferObject.setMessage(new MessageBean(messageCode));

        return shutterTransferObject;
    }

    public static ThermometerTransferObject getThermometerTransferObject(IThermometerModel thermometerModel){
        return new ThermometerTransferObject(
                                                thermometerModel.getTemperature(),
                                                thermometerModel.getModelVariant(),
                                                thermometerModel.getActionMode(),
                                                thermometerModel.getManufacturer(),
                                                thermometerModel.getGenericName(),
                                                thermometerModel.getSerialnumber()
                                            );
    }

    public static ThermometerTransferObject getThermometerTransferObject(IThermometerModel thermometerModel, EMessageCode messageCode)
    {
        ThermometerTransferObject thermometerTransferObject = getThermometerTransferObject(thermometerModel);
        thermometerTransferObject.setMessage(new MessageBean(messageCode));

        return thermometerTransferObject;
    }

    public static WeatherStationTransferObject getWeatherStationTransferObject(IWeatherStationModel weatherStationModel){
        return new WeatherStationTransferObject(
                                                    weatherStationModel.getTemperature(),
                                                    weatherStationModel.getWindVelocity(),
                                                    weatherStationModel.getRainfallAmount(),
                                                    weatherStationModel.getAirPressure(),
                                                    weatherStationModel.getAirHumidity(),
                                                    weatherStationModel.getModelVariant(),
                                                    weatherStationModel.getManufacturer(),
                                                    weatherStationModel.getActionMode(),
                                                    weatherStationModel.getGenericName(),
                                                    weatherStationModel.getSerialnumber()
                                                );
    }

    public static WeatherStationTransferObject getWeatherStationTransferObject(IWeatherStationModel weatherStationModel, EMessageCode messageCode)
    {
        WeatherStationTransferObject weatherStationTransferObject = getWeatherStationTransferObject(weatherStationModel);
        weatherStationTransferObject.setMessage(new MessageBean(messageCode));

        return weatherStationTransferObject;
    }
}