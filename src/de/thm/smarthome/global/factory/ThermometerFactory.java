package de.thm.smarthome.global.factory;

import de.electriccompany.driver.thermometer.IndoorThermometerDriver;
import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.main.device.thermometer.adapter.IndoorThermometerAdapter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

public class ThermometerFactory {
    public static SmartThermometer createThermometer(ManufacturerBean manufacturerBean, ModelVariantBean modelVariantBean, String genericName, String serialnumber){
        return new SmartThermometer(
                new ThermometerLogicCelsius(
                        new ThermometerModel(
                                modelVariantBean,
                                manufacturerBean,
                                new ActionModeBean(EActionMode.CELSIUS),
                                genericName,
                                serialnumber
                        ),
                        new IndoorThermometerAdapter(
                                new IndoorThermometerDriver(serialnumber,genericName)
                        )));
    }
}
