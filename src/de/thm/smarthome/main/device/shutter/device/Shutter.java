package de.thm.smarthome.main.device.shutter.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ShutterClientInterface;
import de.thm.smarthome.global.interfaces.ShutterServerInterface;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.shutter.logic.IShutterLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Tim on 07.04.2017.
 */
public class Shutter extends AObservable implements ISmartDevice, IObserver, ShutterServerInterface {

    private IShutterLogic logic;

    public Shutter(IShutterLogic logic) {

        this.logic = logic;
    }

    public void moveUp(ShutterClientInterface c) {
        logic.moveUp();
    }

    public void moveDown(ShutterClientInterface c) {
        logic.moveDown();
    }

    public boolean isUp(ShutterClientInterface c) {
        return false;
    }

    public boolean isDown(ShutterClientInterface c) {
        return false;
    }

    @Override
    public String getName(ShutterClientInterface c) {

        return logic.getLogicName();
    }

    @Override
    public void update(AObservable o, Object change, ShutterClientInterface c) {

    }

    public void startServer(String shuttername) throws RemoteException {
        ShutterServerInterface stub = (ShutterServerInterface) UnicastRemoteObject.exportObject(this,0);
        LocateRegistry.createRegistry(52000);
        try {
            /*Aktiviert und definiert das Logging des Servers*/
            RemoteServer.setLog(System.out);
            /*Bindet den Server an die folgende Adresse*/
            Naming.rebind("//127.0.0.1/" + shuttername, this);
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
