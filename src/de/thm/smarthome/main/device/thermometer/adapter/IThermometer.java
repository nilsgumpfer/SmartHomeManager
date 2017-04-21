package de.thm.smarthome.main.device.thermometer.adapter;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IThermometer {

    double getTemperature() throws RemoteException;
}
