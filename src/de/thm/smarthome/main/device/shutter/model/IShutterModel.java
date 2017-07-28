package de.thm.smarthome.main.device.shutter.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.observer.IObserver;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IShutterModel {
    public void setCurrentPosition(PositionBean currentPosition);
    public void setDesiredPosition(PositionBean desiredPosition);
    public void setModelVariant(ModelVariantBean modelVariant);
    public void setManufacturer(ManufacturerBean manufacturer);
    public void setActionMode(ActionModeBean actionMode);
    public void setGenericName(String genericName);
    public void setSerialnumber(String serialnumber);

    public PositionBean getCurrentPosition();
    public PositionBean getDesiredPosition();
    public ModelVariantBean getModelVariant();
    public ManufacturerBean getManufacturer();
    public ActionModeBean getActionMode();
    public String getGenericName();
    public String getSerialnumber();
    void attach(IObserver observer);
    void detach(IObserver observer);
}
