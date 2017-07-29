package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class AMoveCommand implements ICommand {
    protected IUpAndDownMovableDevice device          = null;
    protected EMoveDirection moveDirection            = null;
    protected PositionBean oldPosition                = null;

    @Override
    public MessageBean invoke() {
        try {
            //before new position is set, save old position for possible undo-operation
            oldPosition = device.getPosition();

            //any-purpose-method requires switch-case to handle specific part
            switch (moveDirection) {
                case UP:
                    //move up to lowest position
                    return device.moveUp();
                case DOWN:
                    //move down to lowest position
                    return device.moveDown();
                default:
                    return new MessageBean(false);
            }
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
