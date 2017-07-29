package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;

/**
 * Created by Nils on 05.02.2017.
 * * Changed by Jenny on 28.07.2017.
 */
public class ShutterTransferObject {
    PositionBean        currentPosition;
    PositionBean        desiredPosition;
    ModelVariantBean    modelVariant;
    ManufacturerBean    manufacturer;
    ActionModeBean      actionMode;
    String              genericName;
    String              serialnumber;

    public ShutterTransferObject(PositionBean currentPosition, PositionBean desiredPosition, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.currentPosition    = currentPosition;
        this.desiredPosition    = desiredPosition;
        this.modelVariant       = modelVariant;
        this.manufacturer       = manufacturer;
        this.actionMode         = actionMode;
        this.genericName        = genericName;
        this.serialnumber       = serialnumber;
    }

    public PositionBean getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(PositionBean currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PositionBean getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(PositionBean desiredPosition) {
        this.desiredPosition = desiredPosition;
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
}
