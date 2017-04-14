package de.thm.smarthome.main.device.heating.model;

import de.thm.smarthome.global.observer.AObservable;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingModel implements IHeatingModel{
    private String name = "";
    private String heatingModeName = "";
    double temperature = 0;

    @Override
    public String getHeatingName() {
        return null;
    }

    @Override
    public void setHeatingName(String name) {
        this.name = name;
    }

    @Override
    public String getHeatingModeName() {
        return heatingModeName;
    }

    @Override
    public void setHeatingModeName(String heatingModeName) {
        this.heatingModeName = heatingModeName;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
