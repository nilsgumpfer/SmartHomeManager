package de.buderus.driver.heating;

import HeizungServer.interfaces.HeizungClientInterface;
import HeizungServer.interfaces.HeizungServerInterface;
import de.thm.smarthome.global.enumeration.ResponseCode;

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
public class BuderusHeatingDriver implements HeizungClientInterface{
    private String serialnumber;
    private double currentTemperature;
    private double adjustedTemperature;
    private double maxTemperature;
    private double minTemperature;
    private double maxWaterLevel;
    private double minWaterLevel;
    private boolean standby;
    private List<String> listOfLogs = new ArrayList<>();
    private HeizungServerInterface server;

    public BuderusHeatingDriver(String productSerialNumber, String heizungsIP, String heizungsname){

        //TODO: Initialize and connect to heating!
        this.serialnumber = productSerialNumber;
        try{

            LocateRegistry.getRegistry(heizungsIP);

            UnicastRemoteObject.exportObject(this,0);

            Remote ro = Naming.lookup("//"+heizungsIP+"/"+heizungsname);
            System.out.print("Look up done.. trying to communicate \n \n");

            server = (HeizungServerInterface) ro;


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

    public boolean adjustTemperature(double newTemperature)throws RemoteException{

        adjustedTemperature = newTemperature;
        currentTemperature = adjustedTemperature;
        server.setTemperature(newTemperature, this);
        return true;
    }

    public void standby() throws RemoteException{

        server.standby(this);
        standby = true;
    }

    public void wakeUp() throws RemoteException{

        server.wakeUp(this);
        standby = false;
    }

    public List<String> getLogs(){

        //TODO: Invoke command remotely at heating!
        return listOfLogs;
    }

    public double getCurrentTemperature() throws RemoteException{

        currentTemperature = server.getTemperature(this);
        return currentTemperature;
    }

    public boolean setMaxTemperature(double new_maxTemperature) throws RemoteException{
        maxTemperature = new_maxTemperature;
        server.setMaxTemperature(new_maxTemperature, this   );
        return true;
    }

    public boolean setMinTemperature(double new_minTemperature) throws RemoteException{
        minTemperature = new_minTemperature;
        server.setMinTemperature(new_minTemperature, this);
        return true;
    }

    public boolean setMaxWaterLevel(double new_maxWL) throws RemoteException{
        maxWaterLevel = new_maxWL;
        server.setMaxWaterlevel(new_maxWL, this);
        return true;
    }

    public boolean setMinWaterLevel(double new_minWL)throws RemoteException{
        minWaterLevel = new_minWL;
        server.setMinWaterlevel(new_minWL, this);
        return true;
    }

    public double getMaxTemperature() throws RemoteException{
        return server.getMaxTemperature(this);
    }

    public double getMinTemperature() throws RemoteException{
        return server.getMinTemperature(this);
    }

    public double getMaxWaterLevel() throws RemoteException{
        return server.getMaxWaterlevel(this);
    }

    public double getMinWaterLevel() throws RemoteException{
        return server.getMinWaterlevel(this);
    }

    public ResponseCode switchOn() throws RemoteException{
        return server.switchOn(this);
    }

    public ResponseCode switchOff() throws RemoteException{
        return server.switchOff(this);
    }

    public String getStatus() throws RemoteException{
        return server.getStatus(this);
    }

    /*public static void main(String args[]) throws RemoteException {
        BuderusHeatingDriver bd = new BuderusHeatingDriver("1234", "192.168.100.106", "Test");
        bd.setMaxWaterLevel(10.0);
        System.out.print(bd.getMaxWaterLevel());
        bd.switchOn();
        bd.switchOff();
        System.out.print(bd.getStatus());
    }*/
}

