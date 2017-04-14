package de.thm.smarthome.main.manager.controller.commandmanager;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 05.02.2017.
 */
public interface ICommandManager {
    ResponseCode undoLastCommand();
    ResponseCode addTemperatureCommand(double temperature);
    ResponseCode addMoveUpCommand();
    ResponseCode addMoveDownCommand();
}
