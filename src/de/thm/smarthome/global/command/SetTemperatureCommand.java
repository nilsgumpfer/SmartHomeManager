package de.thm.smarthome.global.command;

import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private double value;
    private double old_value;
    private HeatingMemento memento;

    private SetTemperatureCommand(){}

    public SetTemperatureCommand(ITemperatureRelevantDevice device, double value){
        this.device = device;
        this.value = value;
        this.old_value = device.getTemperature();
    }

    @Override
    public int execute() {
        return device.setTemperature(value);
    }

    @Override
    public int undo() {
        return device.setTemperature(old_value);
    }
}
