package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic
{
    private IHeatingModel model;
    private IHeating device;
    private ActionModeBean actionModeBean = new ActionModeBean(EActionMode.MAINTENANCEMODE);

    public HeatingLogicMaintenanceMode(IHeatingModel model, IHeating adapter) {
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
}
