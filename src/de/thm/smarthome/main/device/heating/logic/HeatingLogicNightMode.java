package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicNightMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;
    private String heatingModeName = "NightMode";

    public HeatingLogicNightMode(IHeatingModel model, IHeating device){
        model.setTemperature(17);
    }

    @Override
    public void setTemperature(double temperature) {
        model.setTemperature(temperature);
    }

    @Override
    public double getTemperature() {
        return model.getTemperature();
    }

    @Override
    public String getName() {
        return heatingModeName;
    }
}
