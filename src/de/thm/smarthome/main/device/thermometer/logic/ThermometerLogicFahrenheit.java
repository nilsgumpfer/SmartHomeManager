package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.Thermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicFahrenheit implements IThermometerLogic{
    private IThermometerModel model;
    private IThermometer device;
    private Thermometer thermometer; //TODO: gleiche Frage wie in Klasse selbst: warum gibt´s die hier quasi zwei mal?
    private String logicName = "Fahrenheit";

    public ThermometerLogicFahrenheit(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    @Override
    public double getTemperature() {
        //return thermometer.getTemperature(); (Nils war´s)
        return device.getTemperature();
    }


    public void setTemperatureUnit(){
        //if(thermometer) //TODO: kein java-Script :)
    }
}
