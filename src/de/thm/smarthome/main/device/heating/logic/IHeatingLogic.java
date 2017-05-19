package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.HeatingTransferObject;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface IHeatingLogic {
    String getHeatingName();
    String getHeatingManufacturer();
    String getHeatingModel();
    String getHeatingSerialnumber();
    String getHeatingMode();
    String getHeatingModeName();
    void setHeatingModeName(String heatingModeName);
    ResponseCode setTemperature(double temperature) throws RemoteException;
    double getTemperature() throws RemoteException;
    ResponseCode switchOn() throws RemoteException;
    ResponseCode switchOff() throws RemoteException;
    HeatingTransferObject getHeatingData();
}
