package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicNightMode extends AObservable implements IHeatingLogic, IObserver
{
    private IHeatingModel model;
    private IHeating device;
    private ActionModeBean actionModeBean = new ActionModeBean(EActionMode.NIGHTMODE);

    public HeatingLogicNightMode(IHeatingModel model, IHeating adapter) {
        this.model  = model;
        device      = adapter;
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return model.getCurrentTemperature();
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return model.getDesiredTemperature();
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
    public PowerStateBean getPowerState() {
        return model.getPowerState();
    }

    @Override
    public ActionModeBean getActionMode() {
        return actionModeBean;
    }

    @Override
    public String getGenericName() {
        return model.getGenericName();
    }

    @Override
    public String getSerialnumber() {
        return model.getSerialnumber();
    }

    @Override
    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return device.setDesiredTemperature(temperature);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return device.setPowerState(powerState);
    }

    @Override
    public HeatingTransferObject getHeatingData() {
        return TransferObjectFactory.getHeatingTransferObject(model);
    }

    @Override
    public IHeatingModel getModel() {
        return model;
    }

    @Override
    public IHeating getAdapter() {
        return device;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }
}
