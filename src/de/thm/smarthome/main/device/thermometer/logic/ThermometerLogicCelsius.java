package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.Thermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

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

    public double getTemperature() {
        //return thermometer.getTemperature(); (Nils war´s)
        return model.getTemperature();
    }


    @Override
    public void setTemperatureUnit(){
       // (!thermometer.isCelsius) ? thermometer.setTemperature((thermometer.getTemperature()-32)/1.8) : //TODO: Von Nils: Testweise auskommentiert um Programm lauffähig zu machen @Carlo: bitte noch wie besprochen "vereinfachen"
        if(model.isCelsius()==false){
            model.setTemperature((model.getTemperature()-32)/1.8);
        }
        //Fehlermeldung: "Thermometer misst bereits in Celsius!"
    }
}
