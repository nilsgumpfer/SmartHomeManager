package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;

/**
 * Created by Nils on 15.04.2017.
 */
public class SetPositionCommand implements ICommand {
    IPositionRelevantDevice device;
    PositionBean position;
    PositionBean oldPosition = null;

    private SetPositionCommand(){}

    public SetPositionCommand(IPositionRelevantDevice device, PositionBean position) {
        this.device     = device;
        this.position   = position;
    }

    @Override
    public MessageBean invoke() {
        MessageBean responseCode;

        oldPosition = device.getPosition();
        return device.setPosition(position);
    }

    @Override
    public MessageBean undo() {
        return device.setPosition(oldPosition);
    }
}
