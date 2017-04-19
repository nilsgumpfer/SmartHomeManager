package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.Power;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import sun.security.provider.certpath.OCSPResponse;

/**
 * Created by Nils on 19.04.2017.
 */
public class ASwitchCommand implements ICommand {
    protected IOnAndOffSwitchableDevice device;
    protected ResponseCode oldState             = null;
    protected ResponseCode expectedStatus       = null;
    protected ResponseCode requiredStatus       = null;
    protected Power        powerToDo            = null;

    @Override
    public ResponseCode invoke() {
        ResponseCode responseCode = null;

        //before new state is set, save old one for possible undo-operation
        oldState = device.currentState();

        //check if current status is as expected, do operation
        if(oldState == expectedStatus) {
            switch(powerToDo)
            {
                case On:
                    responseCode = device.switchOn();
                    break;
                case Off:
                    responseCode = device.switchOff();
                    break;
            }
        }
        else
            responseCode = oldState;

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

        //if everything went fine, return success
        if(responseCode == requiredStatus)
            return ResponseCode.CommandInvokedSuccessfully;
        else
            return ResponseCode.CommandInvocationFailed;
    }

    @Override
    public ResponseCode undo() {
        ResponseCode responseCode = null;

        //check if current status is as expected, do operation
        if(oldState == requiredStatus) {
            switch(powerToDo)
            {
                case On:
                    responseCode = device.switchOff();
                    break;
                case Off:
                    responseCode = device.switchOn();
                    break;
            }
        }

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        //if everything went fine, return success
        if(responseCode == oldState)
            return ResponseCode.UndoSuccessful;
        else
            return ResponseCode.UndoFailed;
    }
}
