package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.*;
import de.thm.smarthome.main.device.heating.adapter.MockedHeatingAdapter;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.model.HeatingModel;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.thm.smarthome.main.device.shutter.adapter.MockedShutterAdapter;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.shutter.logic.ShutterLogicMaintenanceMode;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;
import de.thm.smarthome.main.device.thermometer.adapter.MockedThermometerAdapter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;
import de.thm.smarthome.main.device.weatherstation.adapter.MockedWeatherStationAdapter;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMetric;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;
import de.thm.smarthome.main.device.weatherstation.model.WeatherStationModel;

public class MockedDeviceFactory {

    public static SmartHeating getMockedHeating(){
        IHeatingModel model =
            new HeatingModel(
                    new ModelVariantBean(EModelVariant.HEATING_2000),
                    new ManufacturerBean(EDeviceManufacturer.BUDERUS),
                    new ActionModeBean(EActionMode.DAYMODE),
                    "MyHeating",
                    "MH12345",
                    new PowerStateBean(EPowerState.ON)
            );

        model.setDesiredTemperature(new MeasureBean(20, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));

        return new SmartHeating(new HeatingLogicDayMode(model, new MockedHeatingAdapter()));
    }

    public static SmartWeatherStation getMockedWeatherStation() {
        IWeatherStationModel model =
            new WeatherStationModel(
                    new ModelVariantBean(EModelVariant.WeatherStation3000),
                    new ManufacturerBean(EDeviceManufacturer.CONRAD_ELECTRONIC),
                    new ActionModeBean(EActionMode.METRIC),
                    "MyWeatherStation",
                    "MWS12345"
            );

        model.setTemperature(new MeasureBean(23.9, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));
        model.setAirHumidity(new MeasureBean(55.9, EUnitOfMeasurement.RELATION_PERCENT));
        model.setRainfallAmount(new MeasureBean(8.75, EUnitOfMeasurement.VOLUME_LITRESPERSQUAREMETER));
        model.setWindVelocity(new MeasureBean(33.7, EUnitOfMeasurement.VELOCITY_KILOMETERSPERHOUR));
        model.setAirPressure(new MeasureBean(1208.0, EUnitOfMeasurement.PRESSURE_BAR));

        return new SmartWeatherStation(new WeatherStationLogicMetric(model, new MockedWeatherStationAdapter()));
    }

    public static SmartThermometer getMockedThermometer() {
        IThermometerModel model =
            new ThermometerModel(
                    new ModelVariantBean(EModelVariant.Thermometer3000),
                    new ManufacturerBean(EDeviceManufacturer.ELECTRIC_COMPANY),
                    new ActionModeBean(EActionMode.CELSIUS),
                    "MyThermometer",
                    "MT12345"
            );

        model.setTemperature(new MeasureBean(22.9, EUnitOfMeasurement.TEMPERATURE_DEGREESCELSIUS));

        return new SmartThermometer(new ThermometerLogicCelsius(model, new MockedThermometerAdapter()));
    }

    public static SmartShutter getMockedShutter() {
         return new SmartShutter(
                new ShutterLogicMaintenanceMode(
                        new ShutterModel(
                                new ModelVariantBean(EModelVariant.Shutter2000),
                                new ManufacturerBean(EDeviceManufacturer.ELECTRIC_COMPANY),
                                new ActionModeBean(EActionMode.STANDARDMODE),
                                "MyShutter",
                                "MS12345"
                        ),
                new MockedShutterAdapter()));
    }
}
