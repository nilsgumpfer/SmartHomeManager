package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.global.logging.SmartHomeLogger;
import de.thm.smarthome.global.transfer.ThermometerTransferObject;
import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicCelsius implements IThermometerLogic {
    private IThermometerModel model;
    private IThermometer device;
    private String logicName = "Celsius";

    public ThermometerLogicCelsius(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    @Override
    public String getLogicName() {
        return logicName;
    }


//    @Override
//    public void setTemperature() {
//        if(model.isCelsius()==false){
//            model.setTemperature((model.getTemperature()*1.8)+32);
//            model.toggleTemperatureUnit();
//        } else {
//            //TODO: //Fehlermeldung: "Thermometer misst bereits in Celsius!"
//            SmartHomeLogger.log("Thermometer misst bereits in Celsius!");
//        }
//    }

    @Override
    public ThermometerTransferObject getThermometerData() {
        return new ThermometerTransferObject(model.getThermometerName(), model.getThermometerManufacutrer(), model.getThermometerModel(), model.getThermometerSerialnumber(), model.getThermometerTemperature(), "°C");
    }
}
