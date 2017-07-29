package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EPosition;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;
import de.thm.smarthome.main.device.shutter.logic.ShutterLogicMaintenanceMode;
import de.thm.smarthome.main.device.shutter.logic.ShutterLogicStandardMode;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;

/**
 * Created by Nils on 27.01.2017.
 * Changed by Jenny on 28.07.2017.
 */
public class SmartShutter extends AObservable implements IObserver, IUpAndDownMovableDevice, IPositionRelevantDevice{
    private IShutterLogic logic;

    public SmartShutter(IShutterLogic logic) {
        this.logic = logic;
        this.logic.attach(this); //TODO: Tim fragen
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
        notifyObservers(change);
        //TODO: Check if Logic-Change is necessary!
    }

    //setter-Methoden//
    public MessageBean setDesiredPosition(PositionBean desiredPosition) { return logic.setDesiredPosition(desiredPosition); }

    //getter-Methoden//
    public PositionBean getCurrentPosition() {
        return logic.getCurrentPosition();
    }

    public PositionBean getDesiredPosition() {
        return logic.getDesiredPosition();
    }

    public ModelVariantBean getModelVariant() {
        return logic.getModelVariant();
    }

    public ManufacturerBean getManufacturer() {
        return logic.getManufacturer();
    }

    public ActionModeBean getActionMode() {
        return logic.getActionMode();
    }

    public String getGenericName() { return logic.getGenericName(); }

    public String getSerialnumber() {
        return logic.getSerialnumber();
    }

    public ShutterTransferObject getShutterData() {
        return logic.getShutterData();
    }

    public void setActionMode(ActionModeBean actionMode)
    {
        IShutterModel model = logic.getModel();
        IShutter adapter    = logic.getAdapter();

        switch (actionMode.getActionMode_Enum())
        {
            case STANDARDMODE:
                logic = new ShutterLogicStandardMode(model, adapter);
                break;
            case MAINTENANCEMODE:
                logic = new ShutterLogicMaintenanceMode(model, adapter);
                break;
            case NA:
                break;
        }
    }

    @Override
    public MessageBean moveDown() {
        return setDesiredPosition(new PositionBean(EPosition.P0_DOWN));
    }

    @Override
    public MessageBean moveUp() {
        return setDesiredPosition(new PositionBean(EPosition.P5_UP));
    }

    @Override
    public PositionBean getPosition() {
        return getCurrentPosition();
    }

    @Override
    public MessageBean setPosition(PositionBean position) {
        return setDesiredPosition(position);
    }

    @Override
    public boolean isUp() {
        if(getCurrentPosition().getPosition_Enum() == EPosition.P5_UP)
            return true;
        else
            return false;
    }

    @Override
    public boolean isDown() {
        if(getCurrentPosition().getPosition_Enum() == EPosition.P0_DOWN)
            return true;
        else
            return false;
    }
}
