package de.thm.smarthome.global.beans;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 11.06.2017.
 */
public class ManufacturerBean implements Serializable{
    private EDeviceManufacturer deviceManufacturer_Enum;
    private String deviceManufacturer_String = "NULL";

    public ManufacturerBean(EDeviceManufacturer deviceManufacturer_Enum) {
        this.deviceManufacturer_Enum = deviceManufacturer_Enum;
        lookUpString();
    }

    public ManufacturerBean(String deviceManufacturer)
    {
        this.deviceManufacturer_String = deviceManufacturer;
        lookUpEnum();
    }

    public static String[] getHeatingManufacturerEnumsAsStrings() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EDeviceManufacturer.BUDERUS.toString());
        stringArrayList.add(EDeviceManufacturer.VIESSMANN.toString());
        stringArrayList.add(EDeviceManufacturer.VAILLANT.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getShutterManufacturerEnumsAsStrings() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EDeviceManufacturer.ELECTRIC_COMPANY.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getThermometerManufacturerEnumsAsStrings() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EDeviceManufacturer.ELECTRIC_COMPANY.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getWeatherStationManufacturerEnumsAsStrings() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EDeviceManufacturer.CONRAD_ELECTRONIC.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
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
                deviceManufacturer_String = "ConradElectronic";
                break;
            case ELECTRIC_COMPANY:
                deviceManufacturer_String = "ElectricCompany";
                break;
        }
    }

    private void lookUpEnum(){
        switch (deviceManufacturer_String){
            case "NA":
                deviceManufacturer_Enum = EDeviceManufacturer.NA;
                break;
            case "Viessmann":
            case "VIESSMANN":
                deviceManufacturer_Enum = EDeviceManufacturer.VIESSMANN;
                break;
            case "Buderus":
            case "BUDERUS":
                deviceManufacturer_Enum = EDeviceManufacturer.BUDERUS;
                break;
            case "Vaillant":
            case "VAILLANT":
                deviceManufacturer_Enum = EDeviceManufacturer.VAILLANT;
                break;
            case "ConradElectronic":
            case "CONRAD_ELECTRONIC":
                deviceManufacturer_Enum = EDeviceManufacturer.CONRAD_ELECTRONIC;
                break;
            case "ElectricCompany":
            case "ELECTRIC_COMPANY":
                deviceManufacturer_Enum = EDeviceManufacturer.ELECTRIC_COMPANY;
                break;
            default:
                deviceManufacturer_Enum = EDeviceManufacturer.NA;
        }
    }
}
