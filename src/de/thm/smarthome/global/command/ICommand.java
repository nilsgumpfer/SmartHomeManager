package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    ResponseCode invoke();
    ResponseCode undo();
}
