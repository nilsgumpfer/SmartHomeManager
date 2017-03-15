package de.thm.smarthome.global.command;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    int execute();
    int undo();
}
