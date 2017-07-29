package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.*;
import de.thm.smarthome.global.transfer.*;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

import java.util.ArrayList;
import java.util.List;

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

    public static HeatingTransferObject getEmptyHeatingTransferObject(){
        return new HeatingTransferObject(
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new ModelVariantBean(EModelVariant.NA),
                new ManufacturerBean(EDeviceManufacturer.NA),
                new ActionModeBean(EActionMode.NA),
                "N/A",
                "N/A",
                new PowerStateBean(EPowerState.NA)
        );
    }

    public static ShutterTransferObject getEmptyShutterTransferObject(){
        return new ShutterTransferObject(
                new PositionBean(EPosition.NA),
                new PositionBean(EPosition.NA),
                new ModelVariantBean(EModelVariant.NA),
                new ManufacturerBean(EDeviceManufacturer.NA),
                new ActionModeBean(EActionMode.NA),
                "N/A",
                "N/A"
        );
    }

    public static ThermometerTransferObject getEmptyThermometerTransferObject(){
        return new ThermometerTransferObject(
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new ModelVariantBean(EModelVariant.NA),
                new ActionModeBean(EActionMode.NA),
                new ManufacturerBean(EDeviceManufacturer.NA),
                "N/A",
                "N/A"
        );
    }

    public static WeatherStationTransferObject getEmptyWeatherStationTransferObject(){
        return new WeatherStationTransferObject(
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new MeasureBean(0.0, EUnitOfMeasurement.NA),
                new ModelVariantBean(EModelVariant.NA),
                new ManufacturerBean(EDeviceManufacturer.NA),
                new ActionModeBean(EActionMode.NA),
                "N/A",
                "N/A"
        );
    }

    public static ShutterTransferObject[] getEmptyShutterTransferObjects() {
        List<ShutterTransferObject> shutterTransferObjects = new ArrayList<>();

        shutterTransferObjects.add(getEmptyShutterTransferObject());
        shutterTransferObjects.add(getEmptyShutterTransferObject());
        shutterTransferObjects.add(getEmptyShutterTransferObject());
        shutterTransferObjects.add(getEmptyShutterTransferObject());

        return (ShutterTransferObject[]) shutterTransferObjects.toArray();
    }

    public static UserTransferObject getEmptyUserTransferObject() {
        return new UserTransferObject(
                "",
                "",
                "",
                "",
                "",
                new UserGroupBean(EUserGroup.NA)
        );
    }

    public static UserTransferObject[] getEmptyUserTransferObjects() {
        List<UserTransferObject> userTransferObjects = new ArrayList<>();

        userTransferObjects.add(getEmptyUserTransferObject());
        userTransferObjects.add(getEmptyUserTransferObject());
        userTransferObjects.add(getEmptyUserTransferObject());
        userTransferObjects.add(getEmptyUserTransferObject());

        return (UserTransferObject[]) userTransferObjects.toArray();
    }
}
