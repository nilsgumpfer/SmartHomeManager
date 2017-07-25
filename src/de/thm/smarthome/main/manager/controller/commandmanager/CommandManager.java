package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.beans.MeasureBean;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.PositionBean;
import de.thm.smarthome.global.command.*;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.TypeConverter;
import de.thm.smarthome.global.interfaces.IOnAndOffSwitchableDevice;
import de.thm.smarthome.global.interfaces.IPositionRelevantDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;

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
    public MessageBean undoLastCommand(){
        MessageBean responseCode;
        try {
            ICommand command = invokedCommands.get(invokedCommands.size() - 1);
            responseCode = command.undo();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.remove(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("undoLastCommand: UndoFailed");

            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, MeasureBean temperature) {
        MessageBean responseCode;
        try {
            ICommand command = new SetTemperatureCommand(temperatureRelevantDevice, temperature);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetTemperatureCommand: CommandInvocationFailed");

            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addMoveUpCommand() {
        MessageBean responseCode;
        try {
            ICommand command = new CollectiveMoveUpCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addMoveDownCommand() {
        MessageBean responseCode;
        try {
            ICommand command = new CollectiveMoveDownCommand(TypeConverter.convertDeviceList(deviceManager.getSmartShutters()));
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        MessageBean responseCode;
        try {
            ICommand command = new MoveUpCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveUpCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        MessageBean responseCode;
        try {
            ICommand command = new MoveDownCommand(upAndDownMovableDevice);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addMoveDownCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addSetPositionCommand(IPositionRelevantDevice positionRelevantDevice, PositionBean position) {
        MessageBean responseCode;
        try {
            ICommand command = new SetPositionCommand(positionRelevantDevice, position);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSetPositionCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addSwitchOnCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        MessageBean responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOnCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

    @Override
    public MessageBean addSwitchOffCommand(IOnAndOffSwitchableDevice onAndOffTurnableDevice) {
        MessageBean responseCode;
        try {
            ICommand command = new SwitchOnCommand(onAndOffTurnableDevice);
            responseCode = command.invoke();

            if(responseCode.getMessageCode_Enum() == EMessageCode.SUCCESS)
                invokedCommands.add(command);

            return responseCode;
        }
        catch(Exception e){
            SmartHomeLogger.log(e);
            SmartHomeLogger.log("addSwitchOffCommand: CommandInvocationFailed");
            return new MessageBean(false);
        }
    }

}
