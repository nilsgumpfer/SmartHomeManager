package de.thm.smarthome.global.beans;

import de.thm.smarthome.global.enumeration.EModelVariant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 11.06.2017.
 */
public class ModelVariantBean implements Serializable{
    private EModelVariant modelVariant_Enum;
    private String modelVariant_String = "NULL";

    public ModelVariantBean(EModelVariant modelVariant_Enum) {
        this.modelVariant_Enum = modelVariant_Enum;
        lookUpString();
    }

    public ModelVariantBean(String  modelVariant) {
        this.modelVariant_String = modelVariant;
        lookUpEnum();
    }

    public static String[] getHeatingModelEnumsAsString() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EModelVariant.HEATING_1000.toString());
        stringArrayList.add(EModelVariant.HEATING_2000.toString());
        stringArrayList.add(EModelVariant.HEATING_3000.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getShutterModelEnumsAsString() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EModelVariant.Shutter1000.toString());
        stringArrayList.add(EModelVariant.Shutter2000.toString());
        stringArrayList.add(EModelVariant.Shutter3000.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getThermometerModelEnumsAsString() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EModelVariant.Thermometer3000.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public static String[] getWeatherStationModelEnumsAsString() {
        List<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(EModelVariant.WeatherStation3000.toString());

        String [] array = {};
        array = stringArrayList.toArray(array);
        return array;
    }

    public EModelVariant getModelVariant_Enum() {
        return modelVariant_Enum;
    }

    public String getModelVariant_String() {
        return modelVariant_String;
    }

    private void lookUpString(){
        switch (modelVariant_Enum){
            case NA:
                modelVariant_String = "N/A";
                break;
            case HEATING_3000:
                modelVariant_String = "Heizung3000X2";
                break;
            case HEATING_2000:
                modelVariant_String = "Heizung2000X2";
                break;
            case HEATING_1000:
                modelVariant_String = "Heizung1000X2";
                break;
            case Shutter3000:
                modelVariant_String = "Shutter3000";
                break;
            case Shutter2000:
                modelVariant_String = "Shutter2000";
                break;
            case Shutter1000:
                modelVariant_String = "Shutter1000";
                break;
            case Thermometer3000:
                modelVariant_String = "Thermometer3000";
                break;
            case WeatherStation3000:
                modelVariant_String = "WeatherStation3000";
                break;
        }
    }

    private void lookUpEnum(){
        switch (modelVariant_String){
            case "NA":
                modelVariant_Enum = EModelVariant.NA;
                break;
            case "Heizung3000X2":
                modelVariant_Enum = EModelVariant.HEATING_3000;
                break;
            case "Heizung2000X2":
                modelVariant_Enum = EModelVariant.HEATING_2000;
                break;
            case "Heizung1000X2":
                modelVariant_Enum = EModelVariant.HEATING_1000;
                break;
            case "Shutter3000":
                modelVariant_Enum = EModelVariant.Shutter3000;
                break;
            case "Shutter2000":
                modelVariant_Enum = EModelVariant.Shutter2000;
                break;
            case "Shutter1000":
                modelVariant_Enum = EModelVariant.Shutter1000;
                break;
            case "Thermometer3000":
                modelVariant_Enum = EModelVariant.Thermometer3000;
                break;
            case "WeatherStation3000":
                modelVariant_Enum = EModelVariant.WeatherStation3000;
                break;
            default:
                modelVariant_Enum = EModelVariant.NA;
        }
    }
}
