package de.thm.smarthome.main.device.heating.model;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.adapter.IHeating;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingModel extends AObservable implements IHeatingModel, IObserver
{
    MeasureBean currentTemperature;
    MeasureBean desiredTemperature;
    ModelVariantBean modelVariant;
    ManufacturerBean manufacturer;
    ActionModeBean actionMode;
    String genericName;
    String serialnumber;
    PowerStateBean powerState;
    IHeating device;

    public HeatingModel(ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber, PowerStateBean powerState) {
        this.modelVariant   = modelVariant;
        this.manufacturer   = manufacturer;
        this.actionMode     = actionMode;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
        this.powerState     = powerState;
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return currentTemperature;
    }

    @Override
    public void setCurrentTemperature(MeasureBean currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return desiredTemperature;
    }

    @Override
    public void setDesiredTemperature(MeasureBean desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    @Override
    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public ActionModeBean getActionMode() {
        return actionMode;
    }

    @Override
    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
    }

    @Override
    public String getGenericName() {
        return genericName;
    }

    @Override
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public String getSerialnumber() {
        return serialnumber;
    }

    @Override
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Override
    public PowerStateBean getPowerState() {
        return powerState;
    }

    @Override
    public void setPowerState(PowerStateBean powerState) {
        this.powerState = powerState;
    }

    public void setDevice(IHeating device) {
        this.device = device;
    }

    @Override
    public void update(AObservable o, Object change) {
        SmartHomeLogger.log("HeatingModel: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);

        powerState          = device.getPowerState();
        desiredTemperature  = device.getDesiredTemperature();
        currentTemperature  = device.getCurrentTemperature();
    }
}
