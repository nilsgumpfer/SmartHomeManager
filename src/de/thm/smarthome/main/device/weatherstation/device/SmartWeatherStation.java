package de.thm.smarthome.main.device.weatherstation.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartWeatherStation extends AObservable implements ISmartDevice, IObserver{
    private IWeatherStationLogic logic;

    public SmartWeatherStation(IWeatherStationLogic logic) {

        this.logic = logic;
    }

    public double getWindVelocity() {

        return IWeatherStationLogic.getWindVelocity();
    }

    public double getRainfallAmount() {

        return IWeatherStationLogic.getRainfallAmount();
    }

    public double getAirHumidity() {

        return IWeatherStationLogic.getAirHumidity();
    }

    public double getAirPressure() {

        return IWeatherStationLogic.getAirPressure();
    }

    public double getTemperature() {
        return IWeatherStationLogic.getTemperature();
    }

    @Override
    public string getName() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
