package de.thm.smarthome.main.device.thermometer.model;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerModel implements IThermometerModel{
    double temperature = 0;
    boolean isCelsius = true;

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public int getTemperature(){
        return temperature;
    }

    public void toggleTemperatureUnit(){
        (isCelsius) ? isCelsius=false : isCelsius=true;
    }

}
