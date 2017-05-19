package de.thm.smarthome.main.device.thermometer.model;

import de.thm.smarthome.main.device.thermometer.adapter.IndoorThermometerAdapter;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerModel implements IThermometerModel{
    private double temperature = 0;
    private boolean isCelsius = true;
    private String name;

    IndoorThermometerAdapter adapter;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public boolean isCelsius(){
        return isCelsius();
    };
    public void toggleTemperatureUnit(){
        if(isCelsius==true){
            isCelsius=false;
        } else {
            isCelsius=true;
        }
    }


    @Override
    public String getThermometerName() {
        return adapter.getThermometerName();
    }

    @Override
    public String getThermometerManufacutrer() {
        return adapter.getThermometerManufacutrer();
    }

    @Override
    public String getThermometerModel() {
        return adapter.getThermometerModel();
    }

    @Override
    public String getThermometerSerialnumber() {
        return adapter.getThermometerSerialnumber();
    }

    @Override
    public double getThermometerTemperature() {
        return temperature;
    }

}
