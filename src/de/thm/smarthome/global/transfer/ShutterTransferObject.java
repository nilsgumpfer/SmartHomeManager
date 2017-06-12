package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.*;

/**
 * Created by Nils on 05.02.2017.
 */
public class ShutterTransferObject {
    private PositionBean        currentPosition;
    private PositionBean        desiredPosition;
    private ModelVariantBean    modelVariant;
    private ManufacturerBean    manufacturer;
    private ActionModeBean      actionMode;
    private String              genericName;
    private String              serialnumber;
    private MessageBean         message;
    private boolean             moveComplete;

    public ShutterTransferObject(PositionBean currentPosition, PositionBean desiredPosition, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, MessageBean message, boolean moveComplete) {
        this.currentPosition    = currentPosition;
        this.desiredPosition    = desiredPosition;
        this.modelVariant       = modelVariant;
        this.manufacturer       = manufacturer;
        this.actionMode         = actionMode;
        this.genericName        = genericName;
        this.serialnumber       = serialnumber;
        this.message            = message;
        this.moveComplete       = moveComplete;
    }

    public ShutterTransferObject(PositionBean currentPosition, PositionBean desiredPosition, ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, boolean moveComplete) {
        this.currentPosition    = currentPosition;
        this.desiredPosition    = desiredPosition;
        this.modelVariant       = modelVariant;
        this.manufacturer       = manufacturer;
        this.actionMode         = actionMode;
        this.genericName        = genericName;
        this.serialnumber       = serialnumber;
        this.moveComplete       = moveComplete;
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

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public boolean isMoveComplete() {
        return moveComplete;
    }

    public void setMoveComplete(boolean moveComplete) {
        this.moveComplete = moveComplete;
    }
}
