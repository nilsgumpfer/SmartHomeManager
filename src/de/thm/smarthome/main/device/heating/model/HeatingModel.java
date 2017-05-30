package de.thm.smarthome.main.device.heating.model;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.adapter.ViessmannHeatingAdapter;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingModel implements IHeatingModel{
    String heatingName;
    String heatingManufacturer;
    String heatingModel;
    String heatingSerialnumber;
    double temperature = 0.0;
    String heatingMode;


    IHeating adapter;

    public HeatingModel(IHeating adapter) {
        this.adapter = adapter;
    }

    @Override
    public String getHeatingName() {
        return this.heatingName;
    }

    @Override
    public String getHeatingManufacturer() {
        return this.heatingManufacturer;
    }

    @Override
    public String getHeatingModel() {
        return this.heatingModel;
    }

    @Override
    public String getHeatingSerialnumber() {
        return this.heatingSerialnumber;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public String getHeatingMode() {
        return this.heatingMode;
    }

    @Override
    public void setHeatingName(String heatingName) {
        this.heatingName = heatingName;
    }


    public void setHeatingMode(String heatingMode){
        this.heatingMode = heatingMode;
    }




    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
