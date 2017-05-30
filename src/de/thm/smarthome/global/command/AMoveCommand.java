package de.thm.smarthome.global.command;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import de.thm.smarthome.global.enumeration.MoveDirection;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class AMoveCommand implements ICommand {
    protected IUpAndDownMovableDevice device          = null;
    protected MoveDirection moveDirection             = null;
    protected ResponseCode failureCode                = null;
    protected int oldPosition                         = -1;

    @Override
    public ResponseCode invoke() {
        ResponseCode responseCode = null;
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

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

        //in case of error, set flag
        if(responseCode == failureCode)
            errorsOccured = true;

        if(errorsOccured)
            return ResponseCode.CommandInvocationFailed;
        else
            return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode undo() {
        ResponseCode responseCode;
        boolean errorsOccured       = false;

        responseCode = device.setPosition(oldPosition);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        //in case of error, set flag
        if(responseCode == ResponseCode.MoveToPositionFailed)
            errorsOccured = true;

        if(errorsOccured)
            return ResponseCode.UndoFailed;
        else
            return ResponseCode.UndoSuccessful;
    }
}