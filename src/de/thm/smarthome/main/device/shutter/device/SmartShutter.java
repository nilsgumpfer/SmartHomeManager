package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.beans.*;
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
 */
public class SmartShutter extends AObservable implements IObserver{
    private IShutterLogic logic;

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }

    public PositionBean getCurrentPosition() {
        return logic.getCurrentPosition();
    }

    public void setCurrentPosition(PositionBean currentPosition) {
        logic.setCurrentPosition(currentPosition);
    }

    public PositionBean getDesiredPosition() {
        return logic.getDesiredPosition();
    }

    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return logic.setDesiredPosition(desiredPosition);
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

    public String getGenericName() {
        return logic.getGenericName();
    }

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
}
