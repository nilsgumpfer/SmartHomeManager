package de.thm.smarthome.main.manager.model;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.device.SmartHeating;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;
import de.thm.smarthome.main.device.thermometer.device.SmartThermometer;
import de.thm.smarthome.main.device.weatherstation.device.SmartWeatherStation;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHomeModel extends AObservable implements IObserver{
    private SmartHeating smartHeating;
    private SmartWeatherStation smartWeatherStation;
    private SmartThermometer smartThermometer;
    private List<SmartShutter> smartShutters;

    public SmartHeating getSmartHeating() {
        return smartHeating;
    }

    public void setSmartHeating(SmartHeating smartHeating) {
        this.smartHeating = smartHeating;
    }

    public SmartWeatherStation getSmartWeatherStation() {
        return smartWeatherStation;
    }

    public void setSmartWeatherStation(SmartWeatherStation smartWeatherStation) {
        this.smartWeatherStation = smartWeatherStation;
    }

    public SmartThermometer getSmartThermometer() {
        return smartThermometer;
    }

    public void setSmartThermometer(SmartThermometer smartThermometer) {
        this.smartThermometer = smartThermometer;
    }

    public List<SmartShutter> getSmartShutters() {
        return smartShutters;
    }

    public SmartShutter getSmartShutter(String id) {
        return smartShutters.get(0);
    }

    public void addSmartShutter(SmartShutter smartShutter) {
        smartShutters.add(smartShutter);
    }

    public void update(AObservable o, Object change) {

    }
}
