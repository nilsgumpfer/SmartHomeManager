package de.indoorthermometer.driver.thermometer;

import ThermometerServer.interfaces.ThermometerClientInterface;
import ThermometerServer.interfaces.ThermometerServerInterface;

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
public class IndoorThermometerDriver implements ThermometerClientInterface{

    private String serialnumber;
    private double temperature;

    public IndoorThermometerDriver(String productSerialNumber){

        //TODO: Initialize and connect to shutter!
        this.serialnumber = productSerialNumber;
        this.temperature = 21.53;
    }

    public double getTemperature(){

        //TODO: Invoke command remotely at shutter!
        return temperature;
    };

    public void startClient(String thermometerIP, String thermometername){
        try{

            LocateRegistry.getRegistry(thermometerIP);

            UnicastRemoteObject.exportObject(this,0);

            Remote ro = Naming.lookup("//"+thermometerIP+"/"+thermometername);
            System.out.print("Look up done.. trying to communicate \n \n");

            ThermometerServerInterface server = (ThermometerServerInterface) ro;


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
