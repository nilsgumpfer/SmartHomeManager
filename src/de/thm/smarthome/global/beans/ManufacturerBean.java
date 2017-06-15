package de.thm.smarthome.global.beans;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;

/**
 * Created by Nils on 11.06.2017.
 */
public class ManufacturerBean {
    private EDeviceManufacturer deviceManufacturer_Enum;
    private String deviceManufacturer_String = "NULL";

    public ManufacturerBean(EDeviceManufacturer deviceManufacturer_Enum) {
        this.deviceManufacturer_Enum = deviceManufacturer_Enum;
        lookUpString();
    }

    public EDeviceManufacturer getDeviceManufacturer_Enum() {
        return deviceManufacturer_Enum;
    }

    public String getDeviceManufacturer_String() {
        return deviceManufacturer_String;
    }

    private void lookUpString(){
        switch (deviceManufacturer_Enum){
            case NA:
                deviceManufacturer_String = "N/A";
                break;
            case VIESSMANN:
                deviceManufacturer_String = "Viessmann";
                break;
            case BUDERUS:
                deviceManufacturer_String = "Buderus";
                break;
            case VAILLANT:
                deviceManufacturer_String = "Vaillant";
                break;
            case CONRAD_ELECTRONIC:
                deviceManufacturer_String = "Conrad Electronic";
                break;
            case ELECTRIC_COMPANY:
                deviceManufacturer_String = "Electric Company";
                break;
        }
    }
}
