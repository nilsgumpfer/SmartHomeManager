package de.thm.smarthome.main.device.heating.device;

import de.thm.smarthome.global.interfaces.HeizungClientInterface;
import de.thm.smarthome.global.interfaces.HeizungServerInterface;
import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Tim on 07.04.2017.
 */
public class Heizung extends AObservable implements ITemperatureRelevantDevice, ISmartDevice, IObserver, HeizungServerInterface {
    private IHeatingLogic logic;

    public Heizung(IHeatingLogic logic) {
        this.logic = logic;
    }

    @Override
    public int setTemperature(double temperature, HeizungClientInterface c) throws RemoteException {

        return logic.setTemperature(temperature);
    }

    @Override
    public double getTemperature(HeizungClientInterface c) throws RemoteException {

        return logic.getTemperature();
    }

    @Override
    public String getName(HeizungClientInterface c) throws RemoteException {

        return logic.getName();
    }

    @Override
    public void update(AObservable o, Object change, HeizungClientInterface c) throws RemoteException {

    }

    public void startServer(String heizungsname) throws RemoteException{
        HeizungServerInterface stub = (HeizungServerInterface) UnicastRemoteObject.exportObject(this,0);
        LocateRegistry.createRegistry(50000);
        try {
            /*Aktiviert und definiert das Logging des Servers*/
            RemoteServer.setLog(System.out);
            /*Bindet den Server an die folgende Adresse*/
            Naming.rebind("//127.0.0.1/" + heizungsname, this);
            System.out.println("Server ist gestartet!");

        }
        catch (MalformedURLException e){
            e.printStackTrace();
    }
}
