package de.thm.smarthome.global.factory;

import de.buderus.driver.heating.BuderusHeatingDriver;
import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.*;
import de.thm.smarthome.main.device.heating.adapter.BuderusHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.adapter.VaillantHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.ViessmannHeatingAdapter;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;
import de.vaillant.driver.heating.VaillantHeatingDriver;
import de.viessmann.driver.heating.ViessmannHeatingDriver;

/**
 * Created by Nils on 03.02.2017.
 */
public class HeatingFactory {

    public SmartHeating createHeating(EDeviceManufacturer manufacturer, EModelVariant modelVariant, String serialnumber, String genericName){

        //Prepare model
        IHeatingModel heatingModel = new HeatingModel(
                                                        new ModelVariantBean(modelVariant),
                                                        new ManufacturerBean(manufacturer),
                                                        new ActionModeBean(EActionMode.DAYMODE),
                                                        genericName,
                                                        serialnumber,
                                                        new PowerStateBean(EPowerState.ON)
                                                     );

        //Define adapter-variable for later use
        IHeating heatingAdapter = null;

        //Create manufacturer-specific adapter
        switch (manufacturer){
            case BUDERUS:
                BuderusHeatingDriver buderusHeatingDriver       = new BuderusHeatingDriver(serialnumber, genericName);
                heatingAdapter                                  = new BuderusHeatingAdapter(buderusHeatingDriver);
                break;
            case VAILLANT:
                VaillantHeatingDriver vaillantHeatingDriver     = new VaillantHeatingDriver(serialnumber, genericName);
                heatingAdapter                                  = new VaillantHeatingAdapter(vaillantHeatingDriver);
                break;
            case VIESSMANN:
                ViessmannHeatingDriver viessmannHeatingDriver   = new ViessmannHeatingDriver(serialnumber, genericName);
                heatingAdapter                                  = new ViessmannHeatingAdapter(viessmannHeatingDriver);
                break;
            default:
                return null;
        }

        //Unite model and adapter in logic
        IHeatingLogic heatingLogic = new HeatingLogicDayMode(heatingModel, heatingAdapter);

        //Put logic into device (controller) and return it
        return new SmartHeating(heatingLogic);

        //TODO: Observer miteinander verketten (innerhalb der Konstruktoren: an neuem Objekt wird sich angemeldet)
    }
}
