package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;

import java.rmi.RemoteException;

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
    public EMessageCode invoke() throws RemoteException{
        EMessageCode responseCode;

        oldTemperature = device.getTemperature();
        responseCode = device.setTemperature(newTemperature);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Invocation: " + MessageRepository.getMessage(responseCode));

        if(responseCode == EMessageCode.TemperatureAdjustmentFailed)
            return EMessageCode.CommandInvocationFailed;
        else
            return EMessageCode.CommandInvokedSuccessfully;
    }

    @Override
    public EMessageCode undo() throws RemoteException{
        EMessageCode responseCode;

        oldTemperature = device.getTemperature();
        responseCode = device.setTemperature(oldTemperature);

        //Log detailled success- or failure-statements
        SmartHomeLogger.log("Command Undo: " + MessageRepository.getMessage(responseCode));

        if(responseCode == EMessageCode.TemperatureAdjustmentFailed)
            return EMessageCode.CommandInvocationFailed;
        else
            return EMessageCode.CommandInvokedSuccessfully;
    }
}
