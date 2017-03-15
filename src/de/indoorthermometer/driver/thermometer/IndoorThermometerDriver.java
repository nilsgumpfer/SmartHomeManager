package de.indoorthermometer.driver.thermometer;

/**
 * Created by Nils on 27.01.2017.
 */
public class IndoorThermometerDriver {

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
}
