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
//        if(!(logic.getClass().equals(this.logic.getClass())) && weatherStationModel.isMetric()==false){
//
//        }
        if(weatherStationModel.isMetric()==false) {
            //weatherStationModel.setAirHumidity(weatherStationModel.getAirHumidity()*2.54);
            weatherStationModel.setAirPressure(weatherStationModel.getAirPressure() * 14.503773773);
            weatherStationModel.setRainfallAmount(weatherStationModel.getRainfallAmount() * 1.75289575289575);
            weatherStationModel.setWindVelocity(weatherStationModel.getWindVelocity() * 1.60934);
            weatherStationModel.setTemperature((weatherStationModel.getTemperature() - 32) / 1.8);

            //Einheit ändern
            weatherStationModel.toggleMeasuringUnit();
        } else {
            //weatherStationModel.setAirHumidity(weatherStationModel.getAirHumidity()*2.54);
            weatherStationModel.setAirPressure(weatherStationModel.getAirPressure() / 14.503773773);
            weatherStationModel.setRainfallAmount(weatherStationModel.getRainfallAmount() / 1.75289575289575);
            weatherStationModel.setWindVelocity(weatherStationModel.getWindVelocity() / 1.60934);
            weatherStationModel.setTemperature((weatherStationModel.getTemperature() * 1.8) + 32);
        }
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
