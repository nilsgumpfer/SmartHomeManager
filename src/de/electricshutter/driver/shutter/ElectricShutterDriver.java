package de.electricshutter.driver.shutter;

/**
 * Created by Nils on 27.01.2017.
 */
public class ElectricShutterDriver {
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
}
