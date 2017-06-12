package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EPowerState;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.rmi.RemoteException;

/**
 * Created by Nils on 19.04.2017.
 */
public abstract class ASwitchCommand implements ICommand {
    protected IOnAndOffSwitchableDevice device;
    protected EMessageCode oldState             = null;
    protected EMessageCode expectedStatus       = null;
    protected EMessageCode requiredStatus       = null;
    protected EPowerState powerToDo            = null;

    @Override
    public EMessageCode invoke() throws RemoteException{
        EMessageCode responseCode = null;

        //before new state is set, save old one for possible undo-operation
        oldState = device.currentState();

        //check if current status is as expected, do operation
        if(oldState == expectedStatus) {
            switch(powerToDo)
            {
                case ON:
                    responseCode = device.switchOn();
                    break;
                case OFF:
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
            return EMessageCode.CommandInvokedSuccessfully;
        else
            return EMessageCode.CommandInvocationFailed;
    }

    @Override
    public EMessageCode undo() throws RemoteException{
        EMessageCode responseCode = null;

        //check if current status is as expected, do operation
        if(oldState == requiredStatus) {
            switch(powerToDo)
            {
                case ON:
                    responseCode = device.switchOff();
                    break;
                case OFF:
                    responseCode = device.switchOn();
                    break;
            }
        }

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        //if everything went fine, return success
        if(responseCode == oldState)
            return EMessageCode.UndoSuccessful;
        else
            return EMessageCode.UndoFailed;
    }
}
