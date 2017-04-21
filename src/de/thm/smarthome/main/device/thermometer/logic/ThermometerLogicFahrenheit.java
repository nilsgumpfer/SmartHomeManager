package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

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

//    @Override
//    public void setTemperature() {
//        if(model.isCelsius()==false){
//            model.setTemperature((model.getTemperature()-32)/1.8);
//            model.toggleTemperatureUnit();
//        } else {
//            //TODO: //Fehlermeldung: "Thermometer misst bereits in Fahrenheit!"
//            SmartHomeLogger.log("Thermometer misst bereits in Fahrenheit!");
//        }
//    }

    @Override
    public ThermometerTransferObject getThermometerData() {
        ThermometerTransferObject tto = new ThermometerTransferObject(getTemperature(), "°F");
        return tto;
    }
}




