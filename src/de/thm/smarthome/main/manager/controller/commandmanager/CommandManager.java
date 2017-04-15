package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.*;
import de.thm.smarthome.global.converter.MyTypeConverter;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffTurnableDevice;
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
        try {
            ICommand command = invokedCommands.get(invokedCommands.size() - 1);
            command.undo();
            invokedCommands.remove(command);

            return ResponseCode.UndoSuccessful;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);

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

            command.execute();

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

            command.execute();

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

            command.execute();

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

            command.execute();

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

            command.execute();

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
    public ResponseCode addTurnOnCommand(HeatingTransferObject heatingTransferObject) {
        return addTurnOnCommand(deviceManager.getSmartHeating());
    }

    @Override
    public ResponseCode addTurnOffCommand(HeatingTransferObject heatingTransferObject) {
        return addTurnOffCommand(deviceManager.getSmartHeating());
    }

    @Override
    public ResponseCode addTurnOnCommand(IOnAndOffTurnableDevice onAndOffTurnableDevice) {
        try {
            ICommand command = new TurnOnCommand(onAndOffTurnableDevice);

            command.execute();

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
    public ResponseCode addTurnOffCommand(IOnAndOffTurnableDevice onAndOffTurnableDevice) {
        try {
            ICommand command = new TurnOnCommand(onAndOffTurnableDevice);

            command.execute();

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
