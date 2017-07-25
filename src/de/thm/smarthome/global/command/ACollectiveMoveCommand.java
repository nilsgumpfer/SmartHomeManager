package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EMoveDirection;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class ACollectiveMoveCommand implements ICommand{
    protected List<IUpAndDownMovableDevice> devices   = new ArrayList<>();
    protected List<PositionBean> devicepositions      = new ArrayList<>();
    protected EMoveDirection moveDirection            = null;


    public MessageBean invoke() {
        MessageBean responseCode   = null;
        boolean errorsOccured       = false;

        for(IUpAndDownMovableDevice device : devices) {

            //before new position is set, save old position for possible undo-operation
            devicepositions.add(device.getPosition());

            //any-purpose-method requires switch-case to handle specific part
            switch (moveDirection)
            {
                case Up:
                    //move up to highest position
                    responseCode = device.moveUp();
                    break;
                case Down:
                    //move down to lowest position
                    responseCode = device.moveDown();
                    break;
                default:
                    errorsOccured = true;
                    break;
            }

            //Log detailled success- or failure-statements
            //SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

            //in case of error, set flag
            if(responseCode.getMessageCode_Enum() == EMessageCode.FAIL)
                errorsOccured = true;
        }

        return new MessageBean(!errorsOccured);
    }

    public MessageBean undo() {
        MessageBean responseCode;
        boolean errorsOccured       = false;
        int i                       = 0;

        for(IUpAndDownMovableDevice device : devices) {
            //move back to last position
            responseCode = device.setPosition(devicepositions.get(i));

            //in case of error, set flag
            if(responseCode.getMessageCode_Enum() == EMessageCode.FAIL)
                errorsOccured = true;

            //index for position-list
            i++;
        }

        return new MessageBean(!errorsOccured);
    }
}
