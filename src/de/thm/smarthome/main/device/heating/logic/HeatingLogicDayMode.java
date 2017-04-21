package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.rmi.RemoteException;
import java.util.logging.Logger;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicDayMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicDayMode(IHeatingModel model, IHeating device){
        this.device = device;
        this.model = model;
        model.setHeatingModeName("DayMode");
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
    public ResponseCode setTemperature(double temperature) throws RemoteException{
        if(temperature < 0){
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
    public double getTemperature() throws RemoteException{
        return model.getTemperature();
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
        //TODO: just testing!
        return new HeatingTransferObject(device.getTemperature(), UnitOfMeasurement.temperature_DegreesCelsius);
    }

}
