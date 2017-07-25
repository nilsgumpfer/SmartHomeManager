package de.thm.smarthome.global.factory;

import de.buderus.driver.heating.BuderusHeatingDriver;
import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PowerStateBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.main.device.heating.adapter.BuderusHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.adapter.VaillantHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.ViessmannHeatingAdapter;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

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
                //TODO: Change back
                //VaillantHeatingDriver vaillantHeatingDriver     = new VaillantHeatingDriver(serialnumber, genericName);
                BuderusHeatingDriver vaillantHeatingDriver       = new BuderusHeatingDriver(serialnumber, genericName);
                heatingAdapter                                  = new VaillantHeatingAdapter(vaillantHeatingDriver);
                break;
            case VIESSMANN:
                //TODO: Change back
                //ViessmannHeatingDriver viessmannHeatingDriver   = new ViessmannHeatingDriver(serialnumber, genericName);
                BuderusHeatingDriver viessmannHeatingDriver       = new BuderusHeatingDriver(serialnumber, genericName);
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
