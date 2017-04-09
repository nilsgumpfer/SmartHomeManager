package de.thm.smarthome.main.device.thermometer.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartThermometer extends AObservable implements ISmartDevice, IObserver {
    private IThermometerLogic logic;

    public SmartThermometer(IThermometerLogic logic) {

        this.logic = logic;
    }

    @Override
    public String getName() {
        return null;
    }

    public double getTemperature(){
        return logic.getTemperature() ;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
