package de.thm.smarthome.main.device.weatherstation.adapter;

import java.rmi.RemoteException;

/**
 * Created by Nils on 27.01.2017.
 */
public interface IWeatherStation {

    String getWeatherStationName();
    String getWeatherStationManufacturer();
    String getWeatherStationModel();
    String getWeatherStationSerialnumber();
    double getTemperature() throws RemoteException;
    double getWindVelocity() throws RemoteException;
    double getAirPressure() throws RemoteException;
    double getRainfallAmount() throws RemoteException;
}
