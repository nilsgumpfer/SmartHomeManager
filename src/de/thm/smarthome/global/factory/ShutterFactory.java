package de.thm.smarthome.global.factory;

import de.electriccompany.driver.shutter.ElectricShutterDriver;
import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.main.device.shutter.adapter.ElectricShutterAdapter;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.shutter.logic.ShutterLogicStandardMode;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

public class ShutterFactory {
    public static SmartShutter createShutter(ManufacturerBean manufacturerBean, ModelVariantBean modelVariantBean, String genericName, String serialnumber){
        return new SmartShutter(
                new ShutterLogicStandardMode(
                        new ShutterModel(
                                modelVariantBean,
                                manufacturerBean,
                                new ActionModeBean(EActionMode.STANDARDMODE),
                                genericName,
                                serialnumber
                        ),
                        new ElectricShutterAdapter(
                                new ElectricShutterDriver(serialnumber,genericName)
                        )));
    }
}
