package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.*;
import de.thm.smarthome.global.helper.MyTypeConverter;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 05.02.2017.
 */
public class CommandManager implements ICommandManager{
    private static CommandManager ourInstance = new CommandManager();

    private IDeviceManager deviceManager = DeviceManager.getInstance();
    private List<ICommand> invokedCommands = new ArrayList<>();

    private CommandManager() {}

    public static CommandManager getInstance() {
        return ourInstance;
    }

    @Override
    public ResponseCode undoLastCommand(){
        ResponseCode responseCode;
        try {
            ICommand command = invokedCommands.get(invokedCommands.size() - 1);

            responseCode = command.undo();

            if(responseCode == ResponseCode.UndoSuccessful)
                invokedCommands.remove(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("undoLastCommand: UndoFailed");

            return ResponseCode.UndoFailed;
        }
    }

    @Override
    public ResponseCode addSetTemperatureCommand(HeatingTransferObject heatingTransferObject) {
        return addSetTemperatureCommand(deviceManager.getSmartHeating(),heatingTransferObject.getTemperature());
    }

    @Override
    public ResponseCode addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, double temperature) {
        try {
            ICommand command = new SetTemperatureCommand(temperatureRelevantDevice, temperature);

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetTemperatureCommand: CommandInvocationFailed");

            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveUpCommand() {
        try {
            ICommand command = new CollectiveMoveUpCommand(MyTypeConverter.convertDeviceList(deviceManager.getSmartShutters()));

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveDownCommand() {
        try {
            ICommand command = new CollectiveMoveDownCommand(MyTypeConverter.convertDeviceList(deviceManager.getSmartShutters()));

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveUpCommand(ShutterTransferObject shutterTransferObject) {
        return addMoveUpCommand(deviceManager.getSmartShutter(shutterTransferObject));
    }

    @Override
    public ResponseCode addMoveDownCommand(ShutterTransferObject shutterTransferObject) {
        return addMoveDownCommand(deviceManager.getSmartShutter(shutterTransferObject));
    }

    @Override
    public ResponseCode addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        try {
            ICommand command = new MoveUpCommand(upAndDownMovableDevice);

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        try {
            ICommand command = new MoveDownCommand(upAndDownMovableDevice);

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveDownCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addSwitchOnCommand(HeatingTransferObject heatingTransferObject) {
        return addSwitchOnCommand(deviceManager.getSmartHeating());
    }

    @Override
    public ResponseCode addSwitchOffCommand(HeatingTransferObject heatingTransferObject) {
        return addSwitchOffCommand(deviceManager.getSmartHeating());
    }

    @Override
    public ResponseCode addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addTurnOnCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);

            command.invoke();

            invokedCommands.add(command);

            return ResponseCode.CommandInvokedSuccessfully;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addTurnOffCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

}
