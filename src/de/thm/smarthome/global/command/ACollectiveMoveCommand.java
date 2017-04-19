package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.MoveDirection;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class ACollectiveMoveCommand implements ICommand{
    protected List<IUpAndDownMovableDevice> devices   = new ArrayList<>();
    protected List<Integer> devicepositions           = new ArrayList<>();
    protected MoveDirection moveDirection             = null;
    protected ResponseCode failureCode                = null;


    @Override
    public ResponseCode invoke() {
        ResponseCode responseCode   = null;
        boolean errorsOccured       = false;

        for(IUpAndDownMovableDevice device : devices) {

            //before new position is set, save old position for possible undo-operation
            devicepositions.add(device.getPosition());

            //any-purpose-method requires switch-case to handle specific part
            switch (moveDirection)
            {
                case Up:
                    //move up to lowest position
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
            SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

            //in case of error, set flag
            if(responseCode == failureCode)
                errorsOccured = true;
        }

        if(errorsOccured)
            return ResponseCode.CommandInvocationFailed;
        else
            return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode undo() {
        ResponseCode responseCode;
        boolean errorsOccured       = false;
        int i                       = 0;

        for(IUpAndDownMovableDevice device : devices) {
            //move back to last position
            responseCode = device.setPosition(devicepositions.get(i));

            //Log detailled success- or failure-statements
            SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

            //in case of error, set flag
            if(responseCode == ResponseCode.MoveToPositionFailed)
                errorsOccured = true;

            //index for position-list
            i++;
        }

        if(errorsOccured)
            return ResponseCode.UndoFailed;
        else
            return ResponseCode.UndoSuccessful;
    }
}
