package de.thm.smarthome.main.device.heating.model;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.adapter.IHeating;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IHeatingModel {
    MeasureBean getCurrentTemperature();
    void setCurrentTemperature(MeasureBean currentTemperature);
    MeasureBean getDesiredTemperature();
    void setDesiredTemperature(MeasureBean desiredTemperature);
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
    PowerStateBean getPowerState();
    void setPowerState(PowerStateBean powerState);
    void setDevice(IHeating device);
    void attach(Object observer);
    void detach(Object observer);
}
