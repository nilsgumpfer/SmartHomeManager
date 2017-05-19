package de.thm.smarthome.main.device.thermometer.adapter;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IThermometer {

    String getThermometerName();
    String getThermometerManufacutrer();
    String getThermometerModel();
    String getThermometerSerialnumber();
    double getThermometerTemperature() throws RemoteException;
}
