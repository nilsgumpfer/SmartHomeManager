package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.Thermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicFahrenheit implements IThermometerLogic{
    private IThermometerModel model;
    private IThermometer device;
    private String logicName = "Fahrenheit";

    public ThermometerLogicFahrenheit(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    @Override
    public String getLogicName() {
        return logicName;
    }

    public double getTemperature() {
        return model.getTemperature();
    }

    @Override
    public void setTemperature() {
        if(model.isCelsius()==false){
            model.setTemperature((model.getTemperature()-32)/1.8);
            model.toggleTemperatureUnit();
        } else {
            //TODO: //Fehlermeldung: "Thermometer misst bereits in Fahrenheit!"
        }
    }
}




