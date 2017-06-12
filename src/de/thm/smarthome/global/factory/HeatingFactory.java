package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
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

    public SmartHeating createHeating(EDeviceManufacturer variant, String serialnumber, String heizungsIP, String heizungsname){

        switch (variant){
            case BUDERUS:
              return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new BuderusHeatingAdapter(serialnumber, heizungsIP, heizungsname)));
            case VAILLANT:
                return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new VaillantHeatingAdapter(serialnumber, heizungsIP, heizungsname)));
            case VIESSMANN:
                return new SmartHeating(new HeatingLogicDayMode(new HeatingModel(), new ViessmannHeatingAdapter(serialnumber, heizungsIP, heizungsname)));
            default:
                return null;
        }
    }
}
