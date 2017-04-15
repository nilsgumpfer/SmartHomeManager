package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.*;
import de.thm.smarthome.global.helper.TypeConverter;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
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

            if(responseCode != ResponseCode.UndoFailed)
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
        ResponseCode responseCode;
        try {
            ICommand command = new SetTemperatureCommand(temperatureRelevantDevice, temperature);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetTemperatureCommand: CommandInvocationFailed");

            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveUpCommand() {
        ResponseCode responseCode;
        try {
            ICommand command = new CollectiveMoveUpCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveDownCommand() {
        ResponseCode responseCode;
        try {
            ICommand command = new CollectiveMoveDownCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed)
                invokedCommands.add(command);

            return responseCode;
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
        ResponseCode responseCode;
        try {
            ICommand command = new MoveUpCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed && responseCode != ResponseCode.AlreadyMovedUp)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        ResponseCode responseCode;
        try {
            ICommand command = new MoveDownCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed && responseCode != ResponseCode.AlreadyMovedDown)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveDownCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addSetPositionCommand(IPositionRelevantDevice positionRelevantDevice, int position) {
        ResponseCode responseCode;
        try {
            ICommand command = new SetPositionCommand(positionRelevantDevice, position);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed && responseCode != ResponseCode.AlreadyAtThisPosition)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetPositionCommand: CommandInvocationFailed");
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
        ResponseCode responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed && responseCode != ResponseCode.AlreadySwitchedOn)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOnCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

    @Override
    public ResponseCode addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        ResponseCode responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode != ResponseCode.CommandInvocationFailed && responseCode != ResponseCode.AlreadySwitchedOff)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOffCommand: CommandInvocationFailed");
            return ResponseCode.CommandInvocationFailed;
        }
    }

}
