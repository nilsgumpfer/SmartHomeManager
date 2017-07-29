package de.thm.smarthome.main.device.heating.device;

import de.thm.smarthome.global.beans.*;
import de.thm.smarthome.global.enumeration.EActionMode;
import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicDayMode;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicMaintenanceMode;
import de.thm.smarthome.main.device.heating.logic.HeatingLogicNightMode;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;

/**
 * Created by Nils on 27.01.2017.
 */
 public class SmartHeating extends AObservable implements IObserver, IOnAndOffSwitchableDevice, ITemperatureRelevantDevice {
    private IHeatingLogic logic;

    public SmartHeating(IHeatingLogic logic) {
        this.logic = logic;
        this.logic.attach(this);
    }

    @Override
    public void update(AObservable o, Object change) {
        SmartHomeLogger.log("SmartHeating: Detected a change! [" + o.toString() + "]");
        notifyObservers(change);
        //TODO: Check if Logic-Change is necessary!
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

    private MessageBean setDesiredTemperature(MeasureBean temperature) {
        return logic.setDesiredTemperature(temperature);
    }

    private MessageBean setPowerState(PowerStateBean powerState) {
        return logic.setPowerState(powerState);
    }

    public HeatingTransferObject getHeatingData() {
        return logic.getHeatingData();
    }

    public void setActionMode(ActionModeBean actionMode)
    {
        switch (actionMode.getActionMode_Enum())
        {
            case DAYMODE:
                switchLogicTo_DayMode();
                break;
            case NIGHTMODE:
                switchLogicTo_NightMode();
                break;
            case MAINTENANCEMODE:
                switchLogicTo_MaintenanceMode();
                break;
        }
    }

    private void switchLogic_Basis(IHeatingLogic newLogic){
        IHeatingLogic oldLogic = logic;
        switchSubscription(oldLogic, newLogic);
        logic = newLogic;
    }

    private void switchLogicTo_DayMode(){
        switchLogic_Basis(new HeatingLogicDayMode(logic.getModel(), logic.getAdapter()));
        logic.getModel().setActionMode(new ActionModeBean(EActionMode.DAYMODE));
    }

    private void switchLogicTo_NightMode(){
        switchLogic_Basis(new HeatingLogicNightMode(logic.getModel(), logic.getAdapter()));
        logic.getModel().setActionMode(new ActionModeBean(EActionMode.NIGHTMODE));
    }

    private void switchLogicTo_MaintenanceMode(){
        switchLogic_Basis(new HeatingLogicMaintenanceMode(logic.getModel(), logic.getAdapter()));
        logic.getModel().setActionMode(new ActionModeBean(EActionMode.MAINTENANCEMODE));
    }

    private void switchSubscription(IHeatingLogic oldLogic, IHeatingLogic newLogic){
        oldLogic.detach(this);
        newLogic.attach(this);
        oldLogic.getModel().detach((IObserver) oldLogic);
    }

    @Override
    public MessageBean switchOn() {
        return setPowerState(new PowerStateBean(EPowerState.ON));
    }

    @Override
    public MessageBean switchOff() {
        return setPowerState(new PowerStateBean(EPowerState.OFF));
    }

    @Override
    public PowerStateBean currentState() {
        return getPowerState();
    }

    @Override
    public MessageBean setTemperature(MeasureBean temperature) {
        return setDesiredTemperature(temperature);
    }

    @Override
    public MeasureBean getTemperature() {
        return getDesiredTemperature();
    }
}
