package de.thm.smarthome.main.device.thermometer.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ThermometerClientInterface;
import de.thm.smarthome.global.interfaces.ThermometerServerInterface;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Tim on 07.04.2017.
 */
public class Thermometer extends AObservable implements ISmartDevice, IObserver, ThermometerServerInterface {
    private IThermometerLogic logic;

    public Thermometer(IThermometerLogic logic) {

        this.logic = logic;
    }

    @Override
    public string getName(ThermometerClientInterface c) {
        return null;
    }

    public double getTemperature(ThermometerClientInterface c){
        return IThermometerLogic.getTemperature() ;
    }

    @Override
    public void update(AObservable o, Object change, ThermometerClientInterface c) {

    }

    public void startServer(String thermometername) throws RemoteException {
        ThermometerServerInterface stub = (ThermometerServerInterface) UnicastRemoteObject.exportObject(this,0);
        LocateRegistry.createRegistry(53000);
        try {
            /*Aktiviert und definiert das Logging des Servers*/
            RemoteServer.setLog(System.out);
            /*Bindet den Server an die folgende Adresse*/
            Naming.rebind("//127.0.0.1/" + thermometername, this);
            System.out.println("Server ist gestartet!");

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
