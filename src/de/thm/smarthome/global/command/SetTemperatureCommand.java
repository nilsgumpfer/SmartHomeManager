package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private MeasureBean newTemperature;
    private MeasureBean oldTemperature;

    public SetTemperatureCommand(ITemperatureRelevantDevice device, MeasureBean temperature){
        this.device = device;
        this.newTemperature = temperature;
    }

    @Override
    public MessageBean invoke(){
        oldTemperature = device.getTemperature();
        return device.setTemperature(newTemperature);
    }

    @Override
    public MessageBean undo(){
        oldTemperature = device.getTemperature();
        return device.setTemperature(oldTemperature);
    }
}
