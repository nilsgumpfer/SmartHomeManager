package de.viessmann.driver.heating;

import HeizungServer.interfaces.HeizungClientInterface;
import HeizungServer.interfaces.HeizungServerInterface;
import de.thm.smarthome.global.enumeration.EMessageCode;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class ViessmannHeatingDriver implements HeizungClientInterface{
    public ViessmannHeatingDriver(String serialnumber, String genericName) {
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public double getDesiredTemperature() {
        return desiredTemperature;
    }

    public String getModelVariant() {
        return modelVariant;
    }

    public boolean getPowerState() {
        return powerState;
    }

    public boolean setDesiredTemperature(double desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    public boolean setPowerState(boolean powerState) {
        this.powerState = powerState;
    }
    //TODO: 1:1 wie Buderus-Treiber (kopieren, sobald final codiert)
}
