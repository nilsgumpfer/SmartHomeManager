package de.thm.smarthome.main.device.shutter.adapter;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IShutter {
    void moveUp() throws RemoteException;
    void moveDown() throws RemoteException;
    boolean isUp() throws RemoteException;
    boolean isDown() throws RemoteException;
    String getShutterName();
    String getShutterManufacturer();
    String getShutterModel();
    String getShutterSerialnumber();
    int getShutterPosition();
}
