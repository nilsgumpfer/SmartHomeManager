package de.thm.smarthome.main.device.heating.device;

import UI.Controller;
import de.thm.smarthome.global.clockobserver.AClockObservable;
import de.thm.smarthome.global.clockobserver.IClockObserver;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
 public class SmartHeating extends AObservable implements ITemperatureRelevantDevice, ISmartDevice, IObserver, IOnAndOffSwitchableDevice, IClockObserver {
    private IHeatingLogic logic;
    private HeatingModel heatingModel = new HeatingModel();
    private ResponseCode currentState = null;

    public SmartHeating(IHeatingLogic logic) {
        this.logic = logic;
        Controller controller = new Controller();
        controller.attach(this);
    }

    @Override
    public ResponseCode setTemperature(double temperature) {
        logic.setTemperature(temperature);
        //TODO: generate Response-Code
        return ResponseCode.TemperatureAdjustmentSuccessful;
    }

    @Override
    public double getTemperature() {
        return logic.getTemperature();
    }

    @Override
    public String getName() {
        return logic.getHeatingName();
    }

    @Override
    public void update(AObservable o, Object change) {

    }

    @Override
    public ResponseCode switchOn(){
        //TODO: Make this realistic
        currentState = ResponseCode.SwitchedOn;
        return ResponseCode.SwitchedOn;

    }

    @Override
    public ResponseCode switchOff(){
        //TODO: Make this realistic
        currentState = ResponseCode.SwitchedOff;
        return ResponseCode.AlreadySwitchedOff;
    }
@Override
    public ResponseCode currentState(){
        return currentState;
    }

    @Override
    public void update(AClockObservable o, Object change) {

    }
}
