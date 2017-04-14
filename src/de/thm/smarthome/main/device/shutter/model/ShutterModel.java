package de.thm.smarthome.main.device.shutter.model;

import de.thm.smarthome.global.observer.AObservable;

/**
 * Created by Nils on 27.01.2017.
 */
public class ShutterModel implements IShutterModel{
    private String shuttername = "";
    private String logicName = "";
    boolean isUp = true;
    boolean isDown = false;
    int shutterHeight = 0;

    @Override
    public String getShutterName(){
        return shuttername;
    }

    @Override
    public void setShutterName(String shuttername){
       this.shuttername = shuttername;
    }

    @Override
    public String getLogicName(){
        return logicName;
    }

    @Override
    public void setLogicName(String logicName){
        this.logicName = logicName;
    }

    @Override
    public void incrementShutterHeight(){
        if(shutterHeight <5){
            shutterHeight++;
        }
        else{
            //TODO: Fehlermeldung: "Rollläden sind bereits komplett hochgefahren"
        }

        if(shutterHeight == 5){
            isUp = true;
        }
    }

    @Override
    public void decrementShutterHeight() {
        if (shutterHeight > 0) {
            shutterHeight--;
        } else {
            //TODO: Fehlermeldung: "Rollläden sind bereits komplett heruntergefahren"
        }

        if (shutterHeight == 0) {
            isDown = true;
        }
    }

    @Override
    public void setShutterHeight(int value){
        if(value > -1 && value <6){
            shutterHeight = value;
        }
        else{
            //TODO: Fehlermeldung: "Bitte eine Rolllädenhöhe zwischen 0 und 5 eingeben!"
        }
        if(shutterHeight == 5){
            isUp = true;
        }
        if(shutterHeight == 0){
            isDown = true;
        }
    }

    @Override
    public int getShutterHeight(){
        return shutterHeight;
    }

    @Override
    public boolean isUp() {
        if(shutterHeight == 5){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean isDown() {
        if(shutterHeight == 0){
            return true;
        } else{
            return false;
        }
    }

}
