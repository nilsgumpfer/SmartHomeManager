package de.thm.smarthome.main.device.heating.device;

import UI.Controller;
import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.observer.AClockObservable;
import de.thm.smarthome.global.observer.IClockObserver;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicMaintenanceMode;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicNightMode;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
 public class SmartHeating extends AObservable implements IObserver {
    private IHeatingLogic logic;

    @Override
    public void update(AObservable o, Object change) {

    }

    public MeasureBean getCurrentTemperature() {
        return logic.getCurrentTemperature();
    }

    public MeasureBean getDesiredTemperature() {
        return logic.getDesiredTemperature();
    }

    public ModelVariantBean getModelVariant() {
        return logic.getModelVariant();
    }

    public ManufacturerBean getManufacturer() {
        return logic.getManufacturer();
    }

    public PowerStateBean getPowerState() {
        return logic.getPowerState();
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

    public MessageBean setDesiredTemperature(MeasureBean temperature) {
        return logic.setDesiredTemperature(temperature);
    }

    public MessageBean setPowerState(PowerStateBean powerState) {
        return logic.setPowerState(powerState);
    }

    public HeatingTransferObject getHeatingData() {
        return logic.getHeatingData();
    }

    public void setActionMode(ActionModeBean actionMode)
    {
        IHeatingModel model = logic.getModel();
        IHeating adapter    = logic.getAdapter();

        switch (actionMode.getActionMode_Enum())
        {
            case DAYMODE:
                logic = new HeatingLogicDayMode(model, adapter);
                break;
            case NIGHTMODE:
                logic = new HeatingLogicNightMode(model, adapter);
                break;
            case MAINTENANCEMODE:
                logic = new HeatingLogicMaintenanceMode(model, adapter);
                break;
            case NA:
                break;
        }
    }
}
