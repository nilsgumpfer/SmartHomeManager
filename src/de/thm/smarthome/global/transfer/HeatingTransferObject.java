package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;

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
    MessageBean         messageBean;

    public HeatingTransferObject(MeasureBean currentTemperature, MeasureBean desiredTemperature, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, PowerStateBean powerState, MessageBean messageBean) {
        this.currentTemperature = currentTemperature;
        this.desiredTemperature = desiredTemperature;
        this.modelVariant = modelVariant;
        this.manufacturer = manufacturer;
        this.actionMode = actionMode;
        this.genericName = genericName;
        this.serialnumber = serialnumber;
        this.powerState = powerState;
        this.messageBean = messageBean;
        //TODO: native Datentypen als Übergabewerte
    }

    public MeasureBean getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(MeasureBean currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public MeasureBean getDesiredTemperature() {
        return desiredTemperature;
    }

    public void setDesiredTemperature(MeasureBean desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ActionModeBean getActionMode() {
        return actionMode;
    }

    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
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

    public PowerStateBean getPowerState() {
        return powerState;
    }

    public void setPowerState(PowerStateBean powerState) {
        this.powerState = powerState;
    }

    public MessageBean getMessageBean() {
        return messageBean;
    }

    public void setMessageBean(MessageBean messageBean) {
        this.messageBean = messageBean;
    }
}
