package de.thm.smarthome.global.helper;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;

/**
 * Created by Nils on 21.04.2017.
 */
public class ManufacturerRepository {
    private static ManufacturerRepository ourInstance = new ManufacturerRepository();

    public static ManufacturerRepository getInstance() {
        return ourInstance;
    }

    private ManufacturerRepository() {
    }

    public static String getManufacturerAsText(DeviceManufacturer deviceManufacturer){
        switch (deviceManufacturer)
        {
            case BUDERUS:
                return "Buderus";
            case VAILLANT:
                return "Vaillant";
            case VIESSMANN:
                return "Viessmann";
            default:
                return "N/A";
        }
    }
}
