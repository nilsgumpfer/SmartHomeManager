package de.thm.smarthome.main.device.heating.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.main.device.heating.adapter.IHeating;
import de.thm.smarthome.main.device.heating.model.IHeatingModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class HeatingLogicNightMode implements IHeatingLogic {
    private IHeatingModel model;
    private IHeating device;

    public HeatingLogicNightMode(IHeatingModel model, IHeating device){
        model.setHeatingModeName("NightMode");
        //model.setTemperature(18);
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
        if(temperature > 18){
            //ToDo: //Ausgabe: "Die Temperatur darf 18 Grad im Nachtmodus nicht überschreiten!"
            SmartHomeLogger.log("Die Temperatur darf 18 Grad im Nachtmodus nicht überschreiten!");
        } else if(temperature < 0){
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
