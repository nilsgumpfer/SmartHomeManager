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
    /*private String serialnumber;
    private double currentTemperature;
    private double adjustedTemperature;
    private double maxTemperature;
    private double minTemperature;
    private double maxWaterLevel;
    private double minWaterLevel;
    private boolean standby;
    private List<String> listOfLogs = new ArrayList<>();*/


    public BuderusHeatingDriver(String productSerialNumber){

        //TODO: Initialize and connect to heating!

    }

    public boolean adjustTemperature(double newTemperature){

        //TODO: Invoke command remotely at heating!

        return true;
    }

    public void standby(){

    }

    public void wakeUp(){

    }

    public List<String> getLogs(){
        return null;
    }

    public double getCurrentTemperature(){
        return 0;
    }

    public boolean setMaxTemperature(double new_maxTemperature){
        return false;
    }

    public boolean setMinTemperature(double new_minTemperature){
        return false;
    }

    public boolean setMaxWaterLevel(double new_maxWL){
        return false;
    }

    public boolean setMinWaterLevel(double new_minWL){
        return false;
    }


    public double getMaxWaterLevel(){
        return getMaxWaterLevel();
    }

    public double getMinWaterLevel(){
        return getMinWaterLevel();
    }

    public void startClient(String heizungsIP, String heizungsname){
    try{

        LocateRegistry.getRegistry(heizungsIP);

        UnicastRemoteObject.exportObject(this,0);

        Remote ro = Naming.lookup("//"+heizungsIP+"/"+heizungsname);
        System.out.print("Look up done.. trying to communicate \n \n");

        HeizungServerInterface server = (HeizungServerInterface) ro;


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

    public ResponseCode switchOn() {
        return ResponseCode.SwitchOnFailed;
    }

    public ResponseCode switchOff() {
        return ResponseCode.SwitchOffFailed;
    }
}

