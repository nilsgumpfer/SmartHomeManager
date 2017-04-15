package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

import java.util.logging.Logger;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicDayMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicDayMode(IHeatingModel model, IHeating device){
        model.setHeatingModeName("DayMode");
        //model.setTemperature(20);
    }

    @Override
    public String getHeatingName() {
        return model.getHeatingName();
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
    public int setTemperature(double temperature) {
        if(temperature < 0){
            //ToDo: //Ausgabe: "Die Temperatur darf nicht unter 0 Grad eingestellt werden!"
            SmartHomeLogger.log("Die Temperatur darf nicht unter 0 Grad eingestellt werden!");
        } else {
            model.setTemperature(temperature);
        }

        return 1;
    }

    @Override
    public double getTemperature() {
        return model.getTemperature();
    }
}
