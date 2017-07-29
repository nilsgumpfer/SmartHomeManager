package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode extends AObservable implements IHeatingLogic, IObserver
{
    private IHeatingModel model;
    private IHeating device;
    private ActionModeBean actionMode;

    public HeatingLogicMaintenanceMode(IHeatingModel model, IHeating adapter) {
        this.model  = model;
        this.device = adapter;
        this.model.attach(this);
        this.device.attach((IObserver) this.model);
        this.model.setActionMode(new ActionModeBean(EActionMode.MAINTENANCEMODE));
    }

    @Override
    public MeasureBean getCurrentTemperature() {
        return new MeasureBean(0, EUnitOfMeasurement.NA);
    }

    @Override
    public MeasureBean getDesiredTemperature() {
        return new MeasureBean(0, EUnitOfMeasurement.NA);
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
        return model.getActionMode();
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
        return new MessageBean(EMessageCode.FAIL);
    }

    @Override
    public MessageBean setPowerState(PowerStateBean powerState) {
        return new MessageBean(EMessageCode.FAIL);
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
        SmartHomeLogger.log("HeatingLogicMaintenanceMode: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }
}
