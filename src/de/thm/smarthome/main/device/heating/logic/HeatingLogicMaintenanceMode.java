package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicMaintenanceMode(IHeatingModel model,IHeating device){
        model.setHeatingModeName("MaintenanceMode");
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
    public double getTemperature() {
        return model.getTemperature();
    }

    @Override
    public ResponseCode setTemperature(double temperature) {
        SmartHomeLogger.log("Temperatur kann im Wartungsmodus nicht verändert werden!");
        return ResponseCode.TemperatureAdjustmentFailed;
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
