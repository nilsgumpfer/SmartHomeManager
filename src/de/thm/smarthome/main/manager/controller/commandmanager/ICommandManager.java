package de.thm.smarthome.main.manager.controller.commandmanager;

/**
 * Created by Nils on 05.02.2017.
 */
public interface ICommandManager {
    int undoLastCommand();
    int addTemperatureCommand(double temperature);
    int addMoveUpCommand();
    int addMoveDownCommand();
}
