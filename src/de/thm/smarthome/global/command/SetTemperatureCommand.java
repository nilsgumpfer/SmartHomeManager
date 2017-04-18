package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private double value;
    private double oldState;

    private SetTemperatureCommand(){}

    public SetTemperatureCommand(ITemperatureRelevantDevice device, double value){
        this.device = device;
        this.value = value;
    }

    @Override
    public ResponseCode invoke() {
        oldState = device.getTemperature();
        if(oldState != value) {
            device.setTemperature(value);
            return ResponseCode.TemperatureAdjustmentSuccessful;
        }
        //TODO: save current state of device & set temperature
        return ResponseCode.TemperatureAdjustmentFailed;
    }

    @Override
    public ResponseCode undo() {
        device.setTemperature(oldState);
        return ResponseCode.TemperatureAdjustmentSuccessful;
    }
}
