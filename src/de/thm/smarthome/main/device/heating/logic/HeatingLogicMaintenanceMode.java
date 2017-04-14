package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 30.01.2017.
 */
public class HeatingLogicMaintenanceMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicMaintenanceMode(IHeatingModel model,IHeating device){
        model.setHeatingName("MaintenanceMode");
        model.setTemperature(0);
    }

    @Override
    public String getHeatingName() {
        return model.getHeatingName();
    }

    @Override
    public void setHeatingName(String heatingName) {
        model.setHeatingName(heatingName);
    }

    @Override
    public String getHeatingModeName() {
        return model.getHeatingModeName();
    }

    @Override
    public void setHeatingModeName(String heatingModeName) {
        model.setHeatingModeName(heatingModeName);
    }

    @Override
    public double getTemperature() {
        return model.getTemperature();
    }

    @Override
    public int setTemperature(double temperature) {
        //ToDo: Ausgabe: "Temperatur kann im Wartungsmodus nicht verändert werden!"
        SmartHomeLogger.log("Temperatur kann im Wartungsmodus nicht verändert werden!");
        return 1;
    }

}
