package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 */


public class ShutterLogicMaintenanceMode extends AObservable implements IShutterLogic, IObserver
{
    private IShutterModel   model;
    private IShutter        device;
    private ActionModeBean  actionModeBean = new ActionModeBean(EActionMode.MAINTENANCEMODE);

    public ShutterLogicMaintenanceMode(IShutterModel model, IShutter adapter) {
        this.model  = model;
        device      = adapter;
    }

    @Override
    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return device.setDesiredPosition(desiredPosition);
    }

    @Override
    public PositionBean getCurrentPosition() {
        return model.getCurrentPosition();
    }

    @Override
    public PositionBean getDesiredPosition() {
        return model.getDesiredPosition();
    }

    @Override
    public ModelVariantBean getModelVariant() {
        return model.getModelVariant();
    }

    @Override
    public ManufacturerBean getManufacturer() {
        return model.getManufacturer();
    }

    @Override
    public ActionModeBean getActionMode() {
        return actionModeBean;
    }

    @Override
    public String getGenericName() {
        return null;
    }

    @Override
    public String getSerialnumber() {
        return null;
    }

    @Override
    public ShutterTransferObject getShutterData() {
        return TransferObjectFactory.getShutterTransferObject(model);
    }

    @Override
    public IShutterModel getModel() {
        return null;
    }

    @Override
    public IShutter getAdapter() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }
}
