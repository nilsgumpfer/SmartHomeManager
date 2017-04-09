package de.thm.smarthome.main.device.heating.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.interfaces.ITemperatureRelevantDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartHeating extends AObservable implements ITemperatureRelevantDevice, ISmartDevice, IObserver {
    private IHeatingLogic logic;

    public SmartHeating(IHeatingLogic logic) {
        this.logic = logic;
    }

    public void setTemperature(double temperature) {
        logic.setTemperature(temperature);
    }

    public double getTemperature() {
        return logic.getTemperature();
    }

    public String getName() {
        return logic.getName();
    }

    public void update(AObservable o, Object change) {

    }
}
