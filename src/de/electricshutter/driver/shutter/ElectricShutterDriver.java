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
public class ElectricShutterDriver implements ShutterClientInterface{
    private String serialnumber;
    private boolean positionUp;

    public ElectricShutterDriver(String productSerialNumber){

        //TODO: Initialize and connect to shutter!
        this.serialnumber = productSerialNumber;
        this.positionUp = true;
    }

    public void moveUp(){

        //TODO: Invoke command remotely at shutter!
        positionUp = true;
    };
    public void moveDown(){

        //TODO: Invoke command remotely at shutter!
        positionUp = false;
    };
    public boolean isDown(){

        //TODO: Invoke command remotely at shutter!
        if(!positionUp)
            return true;
        else
            return false;
    };
    public boolean isUp(){

        //TODO: Invoke command remotely at shutter!
        if(positionUp)
            return true;
        else
            return false;
    };

    public void startClient(String shutterIP, String shuttername){
        try{

            LocateRegistry.getRegistry(shutterIP);

            UnicastRemoteObject.exportObject(this,0);

            Remote ro = Naming.lookup("//"+shutterIP+"/"+shuttername);
            System.out.print("Look up done.. trying to communicate \n \n");

            ShutterServerInterface server = (ShutterServerInterface) ro;


        } catch (RemoteException e) {
            e.printStackTrace();
        }

        catch (NotBoundException e) {
            e.printStackTrace();
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
