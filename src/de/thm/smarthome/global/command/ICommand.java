package de.thm.smarthome.global.command;

import de.thm.smarthome.global.enumeration.ResponseCode;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ICommand {
    ResponseCode invoke() throws RemoteException;
    ResponseCode undo() throws RemoteException;
}
