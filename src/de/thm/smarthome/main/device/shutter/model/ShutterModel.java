package de.thm.smarthome.main.device.shutter.model;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;

/**
 * Created by Nils on 27.01.2017.
 * Changed by Jenny on 28.07.2017.
 */
/*public class ShutterModel implements IShutterModel*/
public class ShutterModel extends AObservable implements IShutterModel, IObserver
{
    /*private*/ PositionBean currentPosition;
    /*private*/ PositionBean desiredPosition;
    /*private*/ ModelVariantBean modelVariant;
    /*private*/ ManufacturerBean manufacturer;
    /*private*/ ActionModeBean actionMode;
    /*private*/ String genericName;
    /*private*/ String serialnumber;

    IShutter device;

    public ShutterModel(ModelVariantBean modelVariant, ManufacturerBean manufacturer, ActionModeBean actionMode, String genericName, String serialnumber) {
        this.modelVariant = modelVariant;
        this.manufacturer = manufacturer;
        this.actionMode = actionMode;
        this.genericName = genericName;
        this.serialnumber = serialnumber;
    }

    //Setter-Methoden//

    @Override
    public void setCurrentPosition(PositionBean currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public void setDesiredPosition(PositionBean desiredPosition) {
        this.desiredPosition = desiredPosition;
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


    //Getter-Methoden//
    @Override
    public PositionBean getCurrentPosition() { return currentPosition; }

    @Override
    public PositionBean getDesiredPosition() { return desiredPosition; }

    @Override
    public ModelVariantBean getModelVariant() { return modelVariant;   }

    @Override
    public ManufacturerBean getManufacturer() {return manufacturer;    }

    @Override
    public ActionModeBean getActionMode() {
        return actionMode;
    }

    @Override
    public String getGenericName() {return genericName; }

    @Override
    public String getSerialnumber() {
        return serialnumber;
    }

    //*Observer Pattern
    // Die Getter-/Setter-Methoden sind also lediglich zum Abgleich, ob sich Info verändert hat (aber nicht wie).

    @Override
    public void update (AObservable o, Object change)
    {

    };


}
