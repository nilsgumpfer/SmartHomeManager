package de.thm.smarthome.global.interfaces;


import de.thm.smarthome.global.enumeration.EMessageCode;

import java.rmi.RemoteException;

/**
 * Created by Nils on 28.01.2017.
 */
public interface ITemperatureRelevantDevice {
    EMessageCode setTemperature(double temperature) throws RemoteException;
    double getTemperature() throws RemoteException;
}
