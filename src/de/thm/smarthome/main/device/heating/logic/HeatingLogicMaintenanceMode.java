package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicMaintenanceMode(IHeatingModel model,IHeating device){}

    @Override
    public int setTemperature(double temperature) {
        return 0;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
