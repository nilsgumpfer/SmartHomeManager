package de.thm.smarthome.global.factory;

import de.thm.smarthome.global.enumeration.HeatingManufacturers;
import de.thm.smarthome.main.device.heating.device.SmartHeating;

/**
 * Created by Nils on 03.02.2017.
 */
public class HeatingFactory {
    public SmartHeating createHeating(HeatingManufacturers variant, String serialnumber){
        switch (variant){
            case BUDERUS:
                return null;
            case VAILLANT:
                return null;
            case VIESSMANN:
                return null;
            default:
                return null;
        }
    }
}
