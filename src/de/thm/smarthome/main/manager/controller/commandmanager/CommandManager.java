package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.command.ICommand;
import de.thm.smarthome.main.manager.controller.IDeviceManager;
import de.thm.smarthome.main.manager.controller.DeviceManager;

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
    public int undoLastCommand(){
        ICommand command = invokedCommands.get(invokedCommands.size()-1);
        command.undo();
        invokedCommands.remove(command);
        return 0;
    }

    @Override
    public int addTemperatureCommand(double temperature) {
        return 0;
    }

    @Override
    public int addMoveUpCommand() {
        return 0;
    }

    @Override
    public int addMoveDownCommand() {
        return 0;
    }

}
