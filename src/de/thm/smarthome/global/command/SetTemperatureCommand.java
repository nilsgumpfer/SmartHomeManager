package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private double value;
    private double old_value;

    private SetTemperatureCommand(){}

    public SetTemperatureCommand(ITemperatureRelevantDevice device, double value){
        this.device = device;
        this.value = value;
        this.old_value = device.getTemperature();
    }

    @Override
    public ResponseCode invoke() {
        return device.setTemperature(value);
    }

    @Override
    public ResponseCode undo() {
        return device.setTemperature(old_value);
    }
}
