package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;
    private String heatingModeName = "MaintenanceMode";

    public HeatingLogicMaintenanceMode(IHeatingModel model,IHeating device){
        model.setTemperature(0);
    }

    @Override
    public void setTemperature(double temperature) {
        //Ausgabe: "Temperatur kann im Wartungsmodus nicht verändert werden!"
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
