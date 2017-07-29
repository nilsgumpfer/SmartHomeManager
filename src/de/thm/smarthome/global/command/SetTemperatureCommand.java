package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

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
        try
        {
            oldTemperature = device.getTemperature();
            return device.setTemperature(newTemperature);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean undo(){
        try
        {
            oldTemperature = device.getTemperature();
            return device.setTemperature(oldTemperature);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            return new MessageBean(false);
        }
    }
}
