package de.thm.smarthome.main.device.shutter.model;

import de.thm.smarthome.global.observer.AObservable;

/**
 * Created by Nils on 27.01.2017.
 */
public class ShutterModel implements IShutterModel{
    String name = "";
    boolean isUp = true;
    boolean isDown = false;
    int shutterHeight = 0;

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void setName(String name){
       this.name = name;
    }


    @Override
    public void incrementShutterHeight(){
        if(shutterHeight <5){
            shutterHeight++;
        }
        else{
            //Fehlermeldung: "Rollläden sind bereits komplett hochgefahren"
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
            //Fehlermeldung: "Rollläden sind bereits komplett heruntergefahren"
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
            //Fehlermeldung: "Bitte eine Rolllädenhöhe zwischen 0 und 5 eingeben!"
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
