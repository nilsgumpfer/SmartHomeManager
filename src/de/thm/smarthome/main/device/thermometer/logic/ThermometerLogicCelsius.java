package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicCelsius implements IThermometerLogic {
    private IThermometerModel model;
    private IThermometer device;
    private ThermometerModel thermometer;
    private String logicName = "Celsius";

    public ThermometerLogicCelsius(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    public double getTemperature() {
        return thermometer.getTemperature();
    }

    @Override
    public void setTemperatureUnit(){
        if(!thermometer.isCelsius()){
            thermometer.setTemperature((thermometer.getTemperature()-32)/1.8);
            thermometer.toggleTemperatureUnit();
        }
        //Fehlermeldung: "Thermometer misst bereits in Celsius!"
    }
}
