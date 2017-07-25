package de.thm.smarthome.global.beans;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EModelVariant;

import java.io.Serializable;

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

    public ModelVariantBean(EDeviceManufacturer buderus, String modelVariant) {
        //TODO: Based on manufacturer and modelVariant, assign ModelVariant
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
            case Heizung3000:
                modelVariant_String = "Heizung3000X2";
                break;
            case Heizung2000:
                modelVariant_String = "Heizung2000X2";
                break;
            case Heizung1000:
                modelVariant_String = "Heizung1000X2";
                break;
        }
    }
}
