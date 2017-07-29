package de.thm.smarthome.main.device.thermometer.device;

import de.thm.smarthome.global.beans.ActionModeBean;
import de.thm.smarthome.global.beans.ManufacturerBean;
import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.ModelVariantBean;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicFahrenheit;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicMaintenanceMode;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartThermometer extends AObservable implements IObserver
{
    private IThermometerLogic logic;

    public SmartThermometer(IThermometerLogic logic) {
        this.logic = logic;
        this.logic.attach(this);
    }

    @Override
    public void update(AObservable o, Object change) {
        //TODO: Observer-Pattern
    }

    public MeasureBean getTemperature() {
        return logic.getTemperature();
    }

    public ModelVariantBean getModelVariant() {
        return logic.getModelVariant();
    }

    public ManufacturerBean getManufacturer() {
        return logic.getManufacturer();
    }

    public String getGenericName() {
        return logic.getGenericName();
    }

    public String getSerialnumber() {
        return logic.getSerialnumber();
    }

    public ThermometerTransferObject getThermometerData(){
        return logic.getThermometerData();
    }

    public ActionModeBean getActionMode() { return logic.getActionMode(); }

    public void setActionMode(ActionModeBean actionMode)
    {
        IThermometerModel model = logic.getModel();
        IThermometer adapter    = logic.getAdapter();

        switch (actionMode.getActionMode_Enum())
        {
            case CELSIUS:
                logic = new ThermometerLogicCelsius(model, adapter);
                break;
            case FAHRENHEIT:
                logic = new ThermometerLogicFahrenheit(model, adapter);
                break;
            case MAINTENANCEMODE:
                logic = new ThermometerLogicMaintenanceMode(model, adapter);
                break;
            case NA:
                break;
        }
    }
}
