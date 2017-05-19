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
    private ThermometerServerInterface server;

    public IndoorThermometerDriver(String productSerialNumber, String thermometerIP, String thermometername){


        this.serialnumber = productSerialNumber;
        this.temperature = 21.53;
        try{

            LocateRegistry.getRegistry(thermometerIP);

            UnicastRemoteObject.exportObject(this,0);

            Remote ro = Naming.lookup("//"+thermometerIP+"/"+thermometername);
            System.out.print("Look up done.. trying to communicate \n \n");

            server = (ThermometerServerInterface) ro;


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




    public String getThermometerName() {
        return null;
    }

    public String getThermometerManufacturer() {
        return null;
    }

    public String getThermometerModel() {
        return null;
    }

    public String getThermometerSerialnumber() {
        return null;
    }

    public double getThermometerTemperature()throws RemoteException{

        return server.getTemperature(this);
    }


    /*public static void main(String args[]) throws RemoteException {
        IndoorThermometerDriver bd = new IndoorThermometerDriver("1234", "192.168.100.106", "Test");
        System.out.print(bd.getTemperature() + "\n");
    }*/
}
