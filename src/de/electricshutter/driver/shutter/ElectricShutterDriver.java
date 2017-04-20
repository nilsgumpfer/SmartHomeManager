package de.electricshutter.driver.shutter;

import ShutterServer.interfaces.ShutterClientInterface;
import ShutterServer.interfaces.ShutterServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterDriver implements ShutterClientInterface {
    private String serialnumber;
    private boolean positionUp;
    private ShutterServerInterface server;

    public ElectricShutterDriver(String productSerialNumber, String shutterIP, String shuttername) {

        this.serialnumber = productSerialNumber;
        this.positionUp = true;
        try {

            LocateRegistry.getRegistry(shutterIP);

            UnicastRemoteObject.exportObject(this, 0);

            Remote ro = Naming.lookup("//" + shutterIP + "/" + shuttername);
            System.out.print("Look up done.. trying to communicate \n \n");

            server = (ShutterServerInterface) ro;


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void moveUp() throws RemoteException{

        server.moveUp(this);
        positionUp = true;
    }

    public void moveDown() throws RemoteException{

        server.moveDown(this);
        positionUp = false;
    }

    public boolean isDown() throws RemoteException{


        if (!server.isUp(this))
            return true;
        else
            return false;
    }

    public boolean isUp() throws RemoteException{
        if (server.isUp(this))
            return true;
        else
            return false;
    }

    /*public static void main(String args[]) throws RemoteException {
        ElectricShutterDriver bd = new ElectricShutterDriver("1234", "192.168.100.106", "Test");
        bd.moveUp();
        System.out.print(bd.isDown());
}*/
}

