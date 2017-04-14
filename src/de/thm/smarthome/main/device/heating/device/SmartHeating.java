package de.thm.smarthome.main.device.heating.device;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.heating.model.HeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHeating extends AObservable implements ITemperatureRelevantDevice, ISmartDevice, IObserver {
    private IHeatingLogic logic;
    private HeatingModel heatingModel = new HeatingModel();

    public SmartHeating(IHeatingLogic logic, String heatingName) {
        this.logic = logic;
        heatingModel.setHeatingName(heatingName);
    }

    public ResponseCode setTemperature(double temperature) {
        logic.setTemperature(temperature);
        //TODO: generate Response-Code
        return ResponseCode.TemperatureAdjustmentSuccessful;
    }

    public double getTemperature() {
        return logic.getTemperature();
    }

    public String getName() {
        return logic.getHeatingName();
    }

    public void update(AObservable o, Object change) {

    }

    public ResponseCode switchOn(){
        //TODO: Make this realistic
        return ResponseCode.SwitchedOn;
    }

    public ResponseCode switchOff(){
        //TODO: Make this realistic
        return ResponseCode.AlreadySwitchedOff;
    }
}
