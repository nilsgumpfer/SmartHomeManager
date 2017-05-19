package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.rmi.RemoteException;

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
    public String getHeatingManufacturer() {

        return model.getHeatingManufacturer();
    }

    @Override
    public String getHeatingModel() {

        return model.getHeatingModel();
    }

    @Override
    public String getHeatingSerialnumber() {

        return model.getHeatingSerialnumber();
    }

    @Override
    public String getHeatingMode() {

        return model.getHeatingMode();
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
    public ResponseCode switchOn() throws RemoteException{
        return device.switchOn();
    }

    @Override
    public ResponseCode switchOff() throws RemoteException{
        return device.switchOff();
    }

    @Override
    public HeatingTransferObject getHeatingData() {
        return null;
    }

}
