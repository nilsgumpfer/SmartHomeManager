package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.main.device.heating.adapter.MockedHeatingAdapter;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicMaintenanceMode;
import de.thm.smarthome.main.device.heating.model.HeatingModel;
import de.thm.smarthome.main.device.shutter.adapter.MockedShutterAdapter;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.shutter.logic.ShutterLogicMaintenanceMode;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;
import de.thm.smarthome.main.device.thermometer.adapter.MockedThermometerAdapter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;
import de.thm.smarthome.main.device.weatherstation.adapter.MockedWeatherStationAdapter;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMetric;
import de.thm.smarthome.main.device.weatherstation.model.WeatherStationModel;

public class EmptyDeviceFactory {
    public static SmartHeating getEmptyHeating(){
        return new SmartHeating(
                new HeatingLogicMaintenanceMode(
                new HeatingModel(
                        new ModelVariantBean(EModelVariant.NA),
                        new ManufacturerBean(EDeviceManufacturer.NA),
                        new ActionModeBean(EActionMode.NA),
                        "N/A",
                        "N/A",
                        new PowerStateBean(EPowerState.NA)
                ),
                new MockedHeatingAdapter()));
    }

    public static SmartWeatherStation getEmptyWeatherStation() {
        return new SmartWeatherStation(
                new WeatherStationLogicMetric(
                        new WeatherStationModel(
                                new ModelVariantBean(EModelVariant.NA),
                                new ManufacturerBean(EDeviceManufacturer.NA),
                                new ActionModeBean(EActionMode.NA),
                                "N/A",
                                "N/A"
                        ),
                new MockedWeatherStationAdapter()));
    }

    public static SmartThermometer getEmptyThermometer() {
        return new SmartThermometer(
                new ThermometerLogicCelsius(
                        new ThermometerModel(
                                new ModelVariantBean(EModelVariant.NA),
                                new ManufacturerBean(EDeviceManufacturer.NA),
                                new ActionModeBean(EActionMode.NA),
                                "N/A",
                                "N/A"
                        ),
                new MockedThermometerAdapter()));
    }

    public static SmartShutter getEmptyShutter() {
         return new SmartShutter(
                new ShutterLogicMaintenanceMode(
                        new ShutterModel(
                                new ModelVariantBean(EModelVariant.NA),
                                new ManufacturerBean(EDeviceManufacturer.NA),
                                new ActionModeBean(EActionMode.NA),
                                "N/A",
                                "N/A"
                        ),
                new MockedShutterAdapter()));
    }
}
