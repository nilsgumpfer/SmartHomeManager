package de.thm.smarthome.main.device.thermometer.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IThermometerModel
{
    MeasureBean getTemperature();
    void setTemperature(MeasureBean temperature);
    ModelVariantBean getModelVariant();
    void setModelVariant(ModelVariantBean modelVariant);
    ManufacturerBean getManufacturer();
    void setManufacturer(ManufacturerBean manufacturer);
    ActionModeBean getActionMode();
    void setActionMode(ActionModeBean actionMode);
    String getGenericName();
    void setGenericName(String genericName);
    String getSerialnumber();
    void setSerialnumber(String serialnumber);
    void attach(Object observer);
    void detach(Object observer);
    void setDevice(IThermometer device);
}
