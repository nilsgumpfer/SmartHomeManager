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


//    @Override
//    public void setCurrentTemperature() {
//        if(model.isCelsius()==false){
//            model.setCurrentTemperature((model.getCurrentTemperature()-32)/1.8);
//            model.toggleTemperatureUnit();
//        } else {
//            //TODO: //Fehlermeldung: "Thermometer misst bereits in Fahrenheit!"
//            SmartHomeLogger.log("Thermometer misst bereits in Fahrenheit!");
//        }
//    }

    @Override
    public ThermometerTransferObject getThermometerData() {
        return new ThermometerTransferObject(model.getThermometerName(), model.getThermometerManufacturer(), model.getThermometerModel(), model.getThermometerSerialnumber(), model.getThermometerTemperature(), "°C");
    }
}




