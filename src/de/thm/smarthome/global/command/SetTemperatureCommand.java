package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private double value;

    private SetTemperatureCommand(){}

    public SetTemperatureCommand(ITemperatureRelevantDevice device, double value){
        this.device = device;
        this.value = value;
    }

    @Override
    public ResponseCode invoke() {
        //TODO: save current state of device & set temperature
        return ResponseCode.TemperatureAdjustmentFailed;
    }

    @Override
    public ResponseCode undo() {
        //TODO: recover state of device & re-set temperature
        return ResponseCode.TemperatureAdjustmentFailed;
    }
}
