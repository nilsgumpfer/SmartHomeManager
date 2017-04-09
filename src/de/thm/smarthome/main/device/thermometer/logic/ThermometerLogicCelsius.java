package de.thm.smarthome.main.device.thermometer.logic;

import de.thm.smarthome.main.device.thermometer.adapter.IThermometer;
import de.thm.smarthome.main.device.thermometer.device.Thermometer;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class ThermometerLogicCelsius implements IThermometerLogic {
    private IThermometerModel model;
    private IThermometer device;
    private Thermometer thermometer; //TODO: gleiche Frage wie in Klasse selbst: warum gibt´s die hier quasi zwei mal?
    private String logicName = "Celsius";

    public ThermometerLogicCelsius(IThermometerModel model, IThermometer device) {
        this.model = model;
    }

    @Override
    public double getTemperature() {
        //return thermometer.getTemperature(); (Nils war´s)
        return device.getTemperature();
    }


    public void setTemperatureUnit(){
       // (!thermometer.isCelsius) ? thermometer.setTemperature((thermometer.getTemperature()-32)/1.8) : //TODO: Von Nils: Testweise auskommentiert um Programm lauffähig zu machen @Carlo: bitte noch wie besprochen "vereinfachen"
        //Fehlermeldung: "Thermometer misst bereits in Celsius!"
    }
}
