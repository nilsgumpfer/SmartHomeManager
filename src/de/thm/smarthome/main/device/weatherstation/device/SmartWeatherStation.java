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

        //return IWeatherStationLogic.getWindVelocity();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getRainfallAmount() {

        //return IWeatherStationLogic.getRainfallAmount();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getAirHumidity() {

        //return IWeatherStationLogic.getAirHumidity();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getAirPressure() {

        //return IWeatherStationLogic.getAirPressure();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    public double getTemperature() {
        //return IWeatherStationLogic.getTemperature();
        return 0; //TODO: Von Nils: das geht so nicht! :)
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
