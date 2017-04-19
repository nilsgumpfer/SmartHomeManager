package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.manager.controller.commandmanager.CommandManager;

/**
 * Created by Nils on 28.01.2017.
 */
public class SetTemperatureCommand implements ICommand {
    private ITemperatureRelevantDevice device;
    private double newTemperature;
    private double oldTemperature;

    private SetTemperatureCommand(){}

    public SetTemperatureCommand(ITemperatureRelevantDevice device, double value){
        this.device = device;
        this.newTemperature = value;
    }

    @Override
    public ResponseCode invoke() {
        ResponseCode responseCode;

        oldTemperature = device.getTemperature();
        responseCode = device.setTemperature(newTemperature);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

        if(responseCode == ResponseCode.TemperatureAdjustmentFailed)
            return ResponseCode.CommandInvocationFailed;
        else
            return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode undo() {
        ResponseCode responseCode;

        oldTemperature = device.getTemperature();
        responseCode = device.setTemperature(oldTemperature);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        if(responseCode == ResponseCode.TemperatureAdjustmentFailed)
            return ResponseCode.CommandInvocationFailed;
        else
            return ResponseCode.CommandInvokedSuccessfully;
    }
}
