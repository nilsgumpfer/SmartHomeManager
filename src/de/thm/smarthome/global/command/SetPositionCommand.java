package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

/**
 * Created by Nils on 15.04.2017.
 */
public class SetPositionCommand implements ICommand {
    IPositionRelevantDevice device;
    int position;
    int oldPosition = -1;

    private SetPositionCommand(){}

    public SetPositionCommand(IPositionRelevantDevice device, int position) {
        this.device     = device;
        this.position   = position;
    }

    @Override
    public EMessageCode invoke() {
        EMessageCode responseCode;

        oldPosition = device.getPosition();
        responseCode = device.setPosition(position);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

        if(responseCode == EMessageCode.MoveToPositionFailed)
            return EMessageCode.CommandInvocationFailed;
        else
            return EMessageCode.CommandInvokedSuccessfully;
    }

    @Override
    public EMessageCode undo() {
        EMessageCode responseCode;

        responseCode = device.setPosition(oldPosition);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        if(responseCode == EMessageCode.MoveToPositionFailed)
            return EMessageCode.CommandInvocationFailed;
        else
            return EMessageCode.CommandInvokedSuccessfully;
    }
}
