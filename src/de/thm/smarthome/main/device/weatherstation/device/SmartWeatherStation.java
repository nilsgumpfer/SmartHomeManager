package de.thm.smarthome.main.device.weatherstation.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicAngloAmerican;
import de.thm.smarthome.main.device.weatherstation.logic.WeatherStationLogicMetric;
import de.thm.smarthome.main.device.weatherstation.model.WeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartWeatherStation extends AObservable implements ISmartDevice, IObserver{
    private IWeatherStationLogic logic;
    private WeatherStationModel weatherStationModel = new WeatherStationModel();

    public SmartWeatherStation(IWeatherStationLogic logic) {
        this.logic = logic;
        this.logic.setValues();
    }

    public double getWindVelocity() {
        return weatherStationModel.getWindVelocity();
    }

    public double getRainfallAmount() {
        return weatherStationModel.getRainfallAmount();
    }

    public double getAirHumidity() {
        return weatherStationModel.getAirHumidity();
    }

    public double getAirPressure() {
        return weatherStationModel.getAirPressure();
    }

    public double getTemperature() {
        return weatherStationModel.getTemperature();
    }

    public void setTemperature(double temperature){
        weatherStationModel.setTemperature(temperature);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void update(AObservable o, Object change) {

    }
}
