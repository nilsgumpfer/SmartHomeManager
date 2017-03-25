package de.viessmann.driver.heating;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class ViessmannHeatingDriver {
    private String serialnumber;
    private double currentTemperature;
    private double adjustedTemperature;
    private double maxTemperature;
    private double minTemperature;
    private double maxWaterLevel;
    private double minWaterLevel;
    private boolean standby;
    private List<String> listOfLogs = new ArrayList<>();

    public ViessmannHeatingDriver(String productSerialNumber){

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
        standby = true;
    }

    public void wakeUp(){

        //TODO: Invoke command remotely at heating!
        standby = false;
    }

    public List<String> getLogs(){

        //TODO: Invoke command remotely at heating!
        return listOfLogs;
    }

    public double getCurrentTemperature(){

        //TODO: Invoke command remotely at heating!
        return currentTemperature;
    }

    public boolean setMaxTemperature(double new_maxTemperature){
        maxTemperature = new_maxTemperature;
        return true;
    }

    public boolean setMinTemperature(double new_minTemperature){
        minTemperature = new_minTemperature;
        return true;
    }

    public boolean setMaxWaterLevel(double new_maxWL){
        maxWaterLevel = new_maxWL;
        return true;
    }

    public boolean setMinWaterLevel(double new_minWL){
        minWaterLevel = new_minWL;
        return true;
    }

    public double getMaxTemperature(){
        return maxTemperature;
    }

    public double getMinTemperature(){
        return minTemperature;
    }

    public double getMaxWaterLevel(){
        return getMaxWaterLevel();
    }

    public double getMinWaterLevel(){
        return getMinWaterLevel();
    }
}
