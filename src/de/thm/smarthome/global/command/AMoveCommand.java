package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class AMoveCommand implements ICommand {
    protected IUpAndDownMovableDevice device          = null;
    protected EMoveDirection moveDirection            = null;
    protected PositionBean oldPosition                = null;

    @Override
    public MessageBean invoke() {
        MessageBean responseCode = null;
        boolean errorsOccured = false;

        //before new position is set, save old position for possible undo-operation
        oldPosition = device.getPosition();

        //any-purpose-method requires switch-case to handle specific part
        switch (moveDirection)
        {
            case Up:
                //move up to lowest position
                return device.moveUp();
            case Down:
                //move down to lowest position
                return device.moveDown();
            default:
                errorsOccured = true;
                break;
        }

        //in case of error, set flag
        if(responseCode.getMessageCode_Enum() == EMessageCode.FAIL)
            errorsOccured = true;

        return new MessageBean(!errorsOccured);
    }

    @Override
    public MessageBean undo() {
        MessageBean responseCode;
        boolean errorsOccured       = false;

        responseCode = device.setPosition(oldPosition);

        //in case of error, set flag
        if(responseCode.getMessageCode_Enum() == EMessageCode.FAIL)
            errorsOccured = true;

        return new MessageBean(!errorsOccured);
    }
}
