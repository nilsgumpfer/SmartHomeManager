package de.thm.smarthome.main.device.thermometer.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;
import de.thm.smarthome.main.device.thermometer.logic.ThermometerLogicCelsius;
import de.thm.smarthome.main.device.thermometer.model.IThermometerModel;
import de.thm.smarthome.main.device.thermometer.model.ThermometerModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartThermometer extends AObservable implements ISmartDevice, IObserver {
    private IThermometerLogic logic;
    private ThermometerModel thermometerMmodel = new ThermometerModel();
    private String thermometerBezeichnung = "";

    public SmartThermometer(IThermometerLogic logic, String thermometerBezeichnung, double temperature) {
        this.logic = logic;
        this.thermometerBezeichnung = thermometerBezeichnung;
        thermometerMmodel.setTemperature(temperature);
    }

    public String getName() {
        return null;
    }

    public double getTemperature(){
        return thermometerMmodel.getTemperature() ;
    }

    public void setTemperature(double temperature){
        thermometerMmodel.setTemperature(temperature);
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
