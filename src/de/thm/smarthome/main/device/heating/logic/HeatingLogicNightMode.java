package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicNightMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicNightMode(IHeatingModel model, IHeating device){
        model.setHeatingModeName("NightMode");
    }

    @Override
    public String getHeatingName() {
        return model.getHeatingName();
    }

    @Override
    public String getHeatingModeName() {
        return model.getHeatingModeName();
    }

    @Override
    public void setHeatingModeName(String heatingModeName) {
        model.setHeatingModeName(heatingModeName);
    }

    @Override
    public ResponseCode setTemperature(double temperature) {
        if(temperature > 18){
            SmartHomeLogger.log("Die Temperatur darf 18 Grad im Nachtmodus nicht überschreiten!");
            return ResponseCode.TemperatureAdjustmentFailed;
        }
        else if(temperature < 0) {
            SmartHomeLogger.log("Die Temperatur darf nicht unter 0 Grad eingestellt werden!");
            return ResponseCode.TemperatureAdjustmentFailed;
        }
        else {
            if(device.setTemperature(temperature))
                return ResponseCode.TemperatureAdjustmentSuccessful;
            else
                return ResponseCode.TemperatureAdjustmentFailed;
        }
    }

    @Override
    public double getTemperature() {
        return model.getTemperature();
    }

    @Override
    public ResponseCode switchOn() {
        return device.switchOn();
    }

    @Override
    public ResponseCode switchOff() {
        return device.switchOff();
    }

}
