package de.buderus.driver.heating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class BuderusHeatingDriver {
    private String serialnumber;
    private double currentTemperature;
    private double adjustedTemperature;
    private double maxTemperature;
    private double minTemperature;
    private double maxWaterLevel;
    private double minWaterLevel;
    private boolean standby;
    private List<String> listOfLogs = new ArrayList<>();

    /*Teeeeeeeeeeest*/

    //Sven
    //Tim

    //Heinrich Mettmann

    ///BLABLABLABLA Nils

    public BuderusHeatingDriver(String productSerialNumber){

        //TODO: Initialize and connect to heating!
        this.serialnumber = productSerialNumber;
    }

    public boolean adjustTemperature(double newTemperature){

        //TODO: Invoke command remotely at heating!
        adjustedTemperature = newTemperature;
        currentTemperature = adjustedTemperature;
        return true;
    }

    public void standby(){

        //TODO: Invoke command remotely at heating!
        standby = false;
    }

    public void wakeUp(){

        //TODO: Invoke command remotely at heating!
        standby = true;
    }

    public List<String> getLogs(){

        //TODO: Invoke command remotely at heating!
        return listOfLogs;
    }

    public double getCurrentTemperature(){

        //TODO: Invoke command remotely at heating!
        return currentTemperature;
    }
}
