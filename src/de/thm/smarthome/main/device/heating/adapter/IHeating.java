package de.thm.smarthome.main.device.heating.adapter;

//import de.thm.smarthome.main.device.heating.memento.HeatingMemento;

import de.thm.smarthome.global.enumeration.ResponseCode;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IHeating {
    boolean setTemperature(double temperature) throws RemoteException;
    String getHeatingName();
    String getHeatingManufacturer();
    String getHeatingModel();
    String getHeatingSerialnumber();
    double getTemperature();
    String getHeatingMode();
    void standby() throws RemoteException;
    void wakeup() throws RemoteException;
    List<String> getLogs();
    boolean setMaxTemperature(double new_maxTemperature) throws RemoteException;
    boolean setMinTemperature(double new_minTemperature) throws RemoteException;
    boolean setMaxWaterLevel(double new_maxWL) throws RemoteException;
    boolean setMinWaterLevel(double new_minWL) throws RemoteException;
    double getMaxTemperature() throws RemoteException;
    double getMinTemperature() throws RemoteException;
    double getMaxWaterLevel() throws RemoteException;
    double getMinWaterLevel() throws RemoteException;
    ResponseCode switchOn() throws RemoteException;
    ResponseCode switchOff() throws RemoteException;
    String getStatus() throws RemoteException;
}
