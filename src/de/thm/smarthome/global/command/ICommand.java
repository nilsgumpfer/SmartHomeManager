package de.thm.smarthome.global.command;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.enumeration.EMessageCode;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    MessageBean invoke() throws RemoteException;
    MessageBean undo() throws RemoteException;
}
