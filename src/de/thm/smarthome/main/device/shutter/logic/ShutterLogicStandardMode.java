package de.thm.smarthome.main.device.shutter.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.shutter.model.IShutterModel;
import de.thm.smarthome.main.device.shutter.model.ShutterModel;

/**
 * Created by Nils on 27.01.2017.
 * Changed by Jenny on 28.07.2017.
 */
public class ShutterLogicStandardMode extends AObservable implements IShutterLogic, IObserver {
    IShutterModel model;
    IShutter device;
    private ActionModeBean actionModeBean = new ActionModeBean(EActionMode.STANDARDMODE);

    public ShutterLogicStandardMode(IShutterModel model, IShutter adapter) {
        this.model = model;
        this.device = adapter;
        this.model.attach (this);
        this.device.attach((IObserver) this.model);
        this.model.setActionMode(new ActionModeBean(EActionMode.STANDARDMODE));
    }

    //Setter-Methoden//
    @Override
    public MessageBean setDesiredPosition(PositionBean desiredPosition) {
        return device.setDesiredPosition(desiredPosition);
    }

    //Getter-Methoden//
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
        return model.getGenericName(); /*return null*/
    }

    @Override
    public String getSerialnumber() {
        return model.getSerialnumber();
    }

    @Override
    public ShutterTransferObject getShutterData() {
        return TransferObjectFactory.getShutterTransferObject(model);
    }

    @Override
    public IShutterModel getModel() {
        return model;
    }

    @Override
    public IShutter getAdapter() {
        return device;
    }

    @Override
    public void update(AObservable o, Object change) {
        notifyObservers(change);
    }

    //TODO: Observer-Pattern --> Erledigt?

};