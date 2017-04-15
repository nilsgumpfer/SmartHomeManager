package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.ICommand;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.interfaces.IOnAndOffTurnableDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.interfaces.IUpAndDownMovableDevice;
import de.thm.smarthome.global.transfer.HeatingTransferObject;
import de.thm.smarthome.global.transfer.ShutterTransferObject;
import de.thm.smarthome.main.manager.controller.devicemanager.IDeviceManager;
import de.thm.smarthome.main.manager.controller.devicemanager.DeviceManager;

import java.util.List;

/**
 * Created by Nils on 05.02.2017.
 */
public class CommandManager implements ICommandManager{
    private static CommandManager ourInstance = new CommandManager();

    private IDeviceManager smartHomeController = DeviceManager.getInstance();
    private List<ICommand> invokedCommands;

    private CommandManager() {}

    public static CommandManager getInstance() {
        return ourInstance;
    }

    @Override
    public ResponseCode undoLastCommand(){
        ICommand command = invokedCommands.get(invokedCommands.size()-1);
        command.undo();
        invokedCommands.remove(command);
        return ResponseCode.UndoSuccessful;
    }

    @Override
    public ResponseCode addSetTemperatureCommand(HeatingTransferObject heatingTransferObject) {
        return null;
    }

    @Override
    public ResponseCode addSetTemperatureCommand(ITemperatureRelevantDevice temperatureRelevantDevice, double temperature) {
        return null;
    }

    @Override
    public ResponseCode addMoveUpCommand() {
        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode addMoveDownCommand() {
        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode addMoveUpCommand(ShutterTransferObject shutterTransferObject) {
        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode addMoveDownCommand(ShutterTransferObject shutterTransferObject) {
        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode addMoveUpCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        return null;
    }

    @Override
    public ResponseCode addMoveDownCommand(IUpAndDownMovableDevice upAndDownMovableDevice) {
        return null;
    }

    @Override
    public ResponseCode addPowerOnCommand(HeatingTransferObject heatingTransferObject) {
        return null;
    }

    @Override
    public ResponseCode addPowerOffCommand(HeatingTransferObject heatingTransferObject) {
        return null;
    }

    @Override
    public ResponseCode addPowerOnCommand(IOnAndOffTurnableDevice onAndOffTurnableDevice) {
        return ResponseCode.CommandInvokedSuccessfully;
    }

    @Override
    public ResponseCode addPowerOffCommand(IOnAndOffTurnableDevice onAndOffTurnableDevice) {
        return ResponseCode.CommandInvokedSuccessfully;
    }

}
