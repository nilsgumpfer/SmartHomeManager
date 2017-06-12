package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.*;
import de.thm.smarthome.global.helper.TypeConverter;
import de.thm.smarthome.global.enumeration.EMessageCode;
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
    public EMessageCode undoLastCommand(){
        EMessageCode responseCode;
        try {
            ICommand command = invokedCommands.get(invokedCommands.size() - 1);
            responseCode = command.undo();

            if(responseCode != EMessageCode.UndoFailed)
                invokedCommands.remove(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("undoLastCommand: UndoFailed");

            return EMessageCode.UndoFailed;
        }
    }

    @Override
    public EMessageCode addSetTemperatureCommand(HeatingTransferObject heatingTransferObject) {
        return addSetTemperatureCommand(deviceManager.getSmartHeating(),heatingTransferObject.getCurrentTemperature());
    }

    @Override
    public EMessageCode addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, double temperature) {
        EMessageCode responseCode;
        try {
            ICommand command = new SetTemperatureCommand(temperatureRelevantDevice, temperature);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetTemperatureCommand: CommandInvocationFailed");

            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addMoveUpCommand() {
        EMessageCode responseCode;
        try {
            ICommand command = new CollectiveMoveUpCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addMoveDownCommand() {
        EMessageCode responseCode;
        try {
            ICommand command = new CollectiveMoveDownCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadyMovedUp)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addMoveUpCommand(ShutterTransferObject shutterTransferObject) {
        return addMoveUpCommand(deviceManager.getSmartShutter(shutterTransferObject));
    }

    @Override
    public EMessageCode addMoveDownCommand(ShutterTransferObject shutterTransferObject) {
        return addMoveDownCommand(deviceManager.getSmartShutter(shutterTransferObject));
    }

    @Override
    public EMessageCode addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        EMessageCode responseCode;
        try {
            ICommand command = new MoveUpCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadyMovedUp)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        EMessageCode responseCode;
        try {
            ICommand command = new MoveDownCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadyMovedDown)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveDownCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addSetPositionCommand(IPositionRelevantDevice positionRelevantDevice, int position) {
        EMessageCode responseCode;
        try {
            ICommand command = new SetPositionCommand(positionRelevantDevice, position);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadyAtThisPosition)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetPositionCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addSwitchOnCommand(HeatingTransferObject heatingTransferObject) {
        return addSwitchOnCommand(deviceManager.getSmartHeating());
    }

    @Override
    public EMessageCode addSwitchOffCommand(HeatingTransferObject heatingTransferObject) {
        return addSwitchOffCommand(deviceManager.getSmartHeating());
    }

    @Override
    public EMessageCode addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        EMessageCode responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadySwitchedOn)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOnCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

    @Override
    public EMessageCode addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        EMessageCode responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode != EMessageCode.CommandInvocationFailed && responseCode != EMessageCode.AlreadySwitchedOff)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOffCommand: CommandInvocationFailed");
            return EMessageCode.CommandInvocationFailed;
        }
    }

}
