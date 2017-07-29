package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

/**
 * Created by Nils on 15.04.2017.
 */
public class SetPositionCommand implements ICommand {
    IPositionRelevantDevice device;
    PositionBean newPosition           = null;
    PositionBean oldPosition        = null;

    public SetPositionCommand(IPositionRelevantDevice device, PositionBean newPosition) {
        this.device         = device;
        this.newPosition    = newPosition;
    }

    @Override
    public MessageBean invoke() {
        try
        {
            oldPosition = device.getPosition();
            return device.setPosition(newPosition);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean undo() {
        try
        {
            return device.setPosition(oldPosition);
        }
        catch (Exception e)
        {
            SmartHomeLogger.log(e);
            return new MessageBean(false);
        }
    }
}
