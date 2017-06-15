package de.thm.smarthome.main.device.thermometer.model;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.thermometer.adapter.IndoorThermometerAdapter;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerModel extends AObservable implements IThermometerModel, IObserver
{
    private MeasureBean         temperature;
    private ModelVariantBean    modelVariant;
    private ManufacturerBean    manufacturer;
    private ActionModeBean      actionMode;
    private String              genericName;
    private String              serialnumber;

    public ThermometerModel(ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.modelVariant = modelVariant;
        this.manufacturer = manufacturer;
        this.actionMode = actionMode;
        this.genericName = genericName;
        this.serialnumber = serialnumber;
    }

    @Override
    public MeasureBean getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(MeasureBean temperature) {
        this.temperature = temperature;
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
    public void update(AObservable o, Object change) {

    }
}
