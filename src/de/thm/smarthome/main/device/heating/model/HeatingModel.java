package de.thm.smarthome.main.device.heating.model;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.main.device.heating.adapter.ViessmannHeatingAdapter;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingModel implements IHeatingModel{
    private String name = "";
    private String heatingModeName = "";
    double temperature = 0;

    //Stimmt die Verlinkung so? ----------------------------------------------------------------------------
    ViessmannHeatingAdapter adapter;
    //Stimmt die Verlinkung so? ----------------------------------------------------------------------------

    @Override
    public String getHeatingName() {
        return adapter.getHeatingName();
    }

    @Override
    public String getHeatingManufacturer() {
        return adapter.getHeatingManufacturer();
    }

    @Override
    public String getHeatingModel() {
        return adapter.getHeatingModel();
    }

    @Override
    public String getHeatingSerialnumber() {
        return adapter.getHeatingSerialnumber();
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public String getHeatingMode() {
        return adapter.getHeatingMode();
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
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
