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

//TODO: Von Nils: warum gibt es hier eine zusätzliche Thermometer-Klasse, obwohl es doch schon das SmartThermometer gibt??
//TODO: Von Tim: Das hatten wir doch besprochen. Oder habe ich dich da missverstanden?

public class Thermometer extends AObservable implements ISmartDevice, IObserver, ThermometerServerInterface {
    private IThermometerLogic logic;

    public Thermometer(IThermometerLogic logic) {

        this.logic = logic;
    }

    public String getName(ThermometerClientInterface c) {
        return null;
    }

    public double getTemperature(ThermometerClientInterface c){
        //return IThermometerLogic.getTemperature() ; //TODO: Von Nils: das klappt so nicht :)
        return logic.getTemperature() ;
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
