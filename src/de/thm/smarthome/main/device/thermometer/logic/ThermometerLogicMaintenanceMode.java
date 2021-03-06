package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.factory.TransferObjectFactory;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 14.06.2017.
 */
public class ThermometerLogicMaintenanceMode extends AObservable implements IThermometerLogic, IObserver
{
    private IThermometerModel   model;
    private IThermometer        device;
    private ActionModeBean      actionModeBean = new ActionModeBean(EActionMode.MAINTENANCEMODE);

    public ThermometerLogicMaintenanceMode(IThermometerModel model, IThermometer adapter) {
        this.model  = model;
        device      = adapter;
        this.model.attach(this);
        this.device.attach((IObserver) this.model);
        this.model.setActionMode(new ActionModeBean(EActionMode.MAINTENANCEMODE));
        this.model.setDevice(device);
    }

    @Override
    public void update(Object o, Object change) {
        SmartHomeLogger.log("ThermometerLogicMaintenanceMode: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
    }

    @Override
    public MeasureBean getTemperature() {
        return model.getTemperature();
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
        return model.getGenericName();
    }

    @Override
    public String getSerialnumber() {
        return model.getSerialnumber();
    }

    @Override
    public ThermometerTransferObject getThermometerData() {
        return TransferObjectFactory.getThermometerTransferObject(model);
    }

    @Override
    public IThermometerModel getModel() {
        return model;
    }

    @Override
    public IThermometer getAdapter() {
        return device;
    }



}
