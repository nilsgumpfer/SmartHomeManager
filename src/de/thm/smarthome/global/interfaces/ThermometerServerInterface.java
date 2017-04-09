package de.thm.smarthome.global.interfaces;

import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.main.device.thermometer.logic.IThermometerLogic;

import java.rmi.Remote;

/**
 * Created by Tim on 07.04.2017.
 */
public interface ThermometerServerInterface extends Remote {

    public String getName(ThermometerClientInterface c);
    public double getTemperature(ThermometerClientInterface c);
    public void update(AObservable o, Object change, ThermometerClientInterface c);
}
