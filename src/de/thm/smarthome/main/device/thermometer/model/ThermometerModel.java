package de.thm.smarthome.main.device.thermometer.model;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerModel implements IThermometerModel{
    private double temperature = 0;
    private boolean isCelsius = true;
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public double getTemperature(){
        return temperature;
    }
    public boolean isCelsius(){
        return isCelsius();
    };
    public void toggleTemperatureUnit(){
        if(isCelsius) {
            isCelsius = false;
        }
        else{
            isCelsius=true;
        }
    }

}
