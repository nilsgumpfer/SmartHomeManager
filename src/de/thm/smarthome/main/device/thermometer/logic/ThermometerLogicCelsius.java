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
import de.thm.smarthome.main.device.shutter.adapter.IShutter;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicCelsius extends AObservable implements IThermometerLogic, IObserver
{
    private IThermometerModel   model;
    private IThermometer        device;
    private ActionModeBean      actionModeBean = new ActionModeBean(EActionMode.CELSIUS);

    public ThermometerLogicCelsius(IThermometerModel model, IThermometer adapter) {
        this.model  = model;
        device      = adapter;
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
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
