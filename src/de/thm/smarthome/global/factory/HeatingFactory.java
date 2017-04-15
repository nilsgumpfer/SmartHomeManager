package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;
import de.thm.smarthome.main.device.heating.adapter.BuderusHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.VaillantHeatingAdapter;
import de.thm.smarthome.main.device.heating.adapter.ViessmannHeatingAdapter;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.model.HeatingModel;

/**
 * Created by Nils on 03.02.2017.
 */
public class HeatingFactory {

    public SmartHeating createHeating(DeviceManufacturer variant, String serialnumber){

        switch (variant){
            case BUDERUS:
              return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new BuderusHeatingAdapter(serialnumber)));
            case VAILLANT:
                return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new VaillantHeatingAdapter(serialnumber)));
            case VIESSMANN:
                return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new ViessmannHeatingAdapter(serialnumber)));
            default:
                return null;
        }
    }
}
