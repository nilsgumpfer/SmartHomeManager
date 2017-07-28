package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

/**
 * Created by Nils on 05.02.2017.
 */
public class ThermometerTransferObject {
    private MeasureBean         temperature;
    private ModelVariantBean    modelVariant;
    private ManufacturerBean    manufacturer;
    private ActionModeBean      actionMode;
    private String              genericName;
    private String              serialnumber;
    private MessageBean         message;

    private SmartThermometer smartThermometer;
    private ThermometerModel thermometerModel;

    public ThermometerTransferObject(MeasureBean temperature, ModelVariantBean modelVariant, ActionModeBean actionMode, ManufacturerBean manufacturer, String genericName, String serialnumber, MessageBean message) {
        this.temperature    = temperature;
        this.modelVariant   = modelVariant;
        this.actionMode     = actionMode;
        this.manufacturer   = manufacturer;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
        this.message        = message;
    }

    public ThermometerTransferObject(MeasureBean temperature, ModelVariantBean modelVariant, ActionModeBean actionMode, ManufacturerBean manufacturer, String genericName, String serialnumber) {
        this.temperature    = temperature;
        this.modelVariant   = modelVariant;
        this.actionMode     = actionMode;
        this.manufacturer   = manufacturer;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
    }

    public MeasureBean getTemperature() {
        return temperature;
    }

    public void setTemperature(MeasureBean temperature) {
        this.temperature = temperature;
    }

    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    public ActionModeBean getActionMode() {
        return actionMode;
    }

    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
    }

    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }
}
