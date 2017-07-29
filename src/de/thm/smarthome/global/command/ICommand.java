package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    MessageBean invoke();
    MessageBean undo();
}
