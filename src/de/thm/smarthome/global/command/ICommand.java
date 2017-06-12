package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.EMessageCode;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    EMessageCode invoke() throws RemoteException;
    EMessageCode undo() throws RemoteException;
}
