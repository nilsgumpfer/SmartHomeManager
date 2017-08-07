package de.thm.smarthome.main.device.thermometer.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;

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
    IThermometer device;

    public ThermometerModel(ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.modelVariant   = modelVariant;
        this.manufacturer   = manufacturer;
        this.actionMode     = actionMode;
        this.genericName    = genericName;
        this.serialnumber   = serialnumber;
        temperature         = new MeasureBean(0.0, EUnitOfMeasurement.NA);
    }


    //Setter//
    @Override
    public void setTemperature(MeasureBean temperature) {
        this.temperature = temperature;
    }

    @Override
    public void setModelVariant(ModelVariantBean modelVariant) {
        this.modelVariant = modelVariant;
    }

    @Override
    public void setManufacturer(ManufacturerBean manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public void setActionMode(ActionModeBean actionMode) {
        this.actionMode = actionMode;
    }

    @Override
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    @Override
    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Override
    public void setDevice(IThermometer device) {
        this.device = device;
    }


    //Getter//
    @Override
    public MeasureBean getTemperature() {
        return temperature;
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return modelVariant;
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return manufacturer;
    }

    @Override
    public ActionModeBean getActionMode() {
        return actionMode;
    }

    @Override
    public String getGenericName() {
        return genericName;
    }

   @Override
    public String getSerialnumber() {
        return serialnumber;
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("ThermometerModel: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);

        setTemperature(device.getTemperature());;
    }
}
