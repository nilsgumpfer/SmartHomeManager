package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicCelsius implements IThermometerLogic {
    private IThermometerModel model;
    private IThermometer device;
    private Thermometer thermometer;
    private logicName = "Celsius";

    public ThermometerLogicCelsius(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    @Override
    public double getTemperature() {
        return thermometer.getTemperature();
    }

    @Override
    public void setTemperatureUnit(){
        (!thermometer.isCelsius) ? thermometer.setTemperature((thermometer.getTemperature()-32)/1.8) :
        //Fehlermeldung: "Thermometer misst bereits in Celsius!"
    }
}
