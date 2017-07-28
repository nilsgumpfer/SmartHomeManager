package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.heating.model.HeatingModel;

/**
 * Created by Nils on 05.02.2017.
 */
public class HeatingTransferObject {
    MeasureBean         currentTemperature;
    MeasureBean         desiredTemperature;
    ModelVariantBean    modelVariant;
    ManufacturerBean    manufacturer;
    ActionModeBean      actionMode;
    String              genericName;
    String              serialnumber;
    PowerStateBean      powerState;
    MessageBean         message;

    private SmartHeating smartHeating;
    private HeatingModel heatingModel;

    public HeatingTransferObject(MeasureBean currentTemperature, MeasureBean desiredTemperature, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, PowerStateBean powerState, MessageBean message) {
        this.currentTemperature     = currentTemperature;
        this.desiredTemperature     = desiredTemperature;
        this.modelVariant           = modelVariant;
        this.manufacturer           = manufacturer;
        this.actionMode             = actionMode;
        this.genericName            = genericName;
        this.serialnumber           = serialnumber;
        this.powerState             = powerState;
        this.message                = message;
    }

    public HeatingTransferObject(MeasureBean currentTemperature, MeasureBean desiredTemperature, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, PowerStateBean powerState) {
        this.currentTemperature     = currentTemperature;
        this.desiredTemperature     = desiredTemperature;
        this.modelVariant           = modelVariant;
        this.manufacturer           = manufacturer;
        this.actionMode             = actionMode;
        this.genericName            = genericName;
        this.serialnumber           = serialnumber;
        this.powerState             = powerState;
    }

    public MeasureBean getCurrentTemperature() {
        //return currentTemperature;
        return smartHeating.getCurrentTemperature();
    }

    public void setCurrentTemperature(MeasureBean currentTemperature) {
        this.currentTemperature = currentTemperature;
        heatingModel.setCurrentTemperature(this.currentTemperature);
    }

    public MeasureBean getDesiredTemperature() {
        //return desiredTemperature;
        return smartHeating.getDesiredTemperature();
    }

    public void setDesiredTemperature(MeasureBean desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
        heatingModel.setDesiredTemperature(this.desiredTemperature);
    }

    public ModelVariantBean getModelVariant() {
        //return modelVariant;
        return smartHeating.getModelVariant();
    }

    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
        heatingModel.setModelVariant(this.modelVariant);
    }

    public ManufacturerBean getManufacturer() {
        //return manufacturer;
        return smartHeating.getManufacturer();
    }

    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
        heatingModel.setManufacturer(this.manufacturer);
    }

    public ActionModeBean getActionMode() {
        //return actionMode;
        return smartHeating.getActionMode();
    }

    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
        heatingModel.setActionMode(this.actionMode);
    }

    public String getGenericName() {
        //return genericName;
        return smartHeating.getGenericName();
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
        heatingModel.setGenericName(this.genericName);
    }

    public String getSerialnumber() {
        //return serialnumber;
    return smartHeating.getSerialnumber();
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
        heatingModel.setSerialnumber(this.serialnumber);
    }

    public PowerStateBean getPowerState() {
        //return powerState;
        return smartHeating.getPowerState();
    }

    public void setPowerState(PowerStateBean powerState) {
        this.powerState = powerState;
        heatingModel.setPowerState(this.powerState);
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) { this.message = message; }
}
