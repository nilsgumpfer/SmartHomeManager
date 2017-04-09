package de.thm.smarthome.main.device.weatherstation.device;

import de.thm.smarthome.global.interfaces.ISmartDevice;
import de.thm.smarthome.global.observer.AObservable;
import de.thm.smarthome.global.observer.IObserver;
import de.thm.smarthome.main.device.heating.logic.IHeatingLogic;
import de.thm.smarthome.main.device.weatherstation.logic.IWeatherStationLogic;
import de.thm.smarthome.main.device.weatherstation.model.WeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class SmartWeatherStation extends AObservable implements ISmartDevice, IObserver{
    private IWeatherStationLogic logic;
    private WeatherStationModel weatherStationModel = new WeatherStationModel();

    public SmartWeatherStation(IWeatherStationLogic logic) {
        this.logic = logic;
        if(weatherStationModel.isMetric()==false){
            weatherStationModel.setAirHumidity(weatherStationModel.getAirHumidity()*2.54);
            weatherStationModel.setAirPressure(weatherStationModel.getAirPressure()*2.54);
            weatherStationModel.setRainfallAmount(weatherStationModel.getRainfallAmount()*2.54);
            weatherStationModel.setWindVelocity(weatherStationModel.getWindVelocity()*2.54);
            //weatherStationModel.setTemperature(weatherStationModel.getTemperature()*2.54);
        }
    }

    public double getWindVelocity() {
        return weatherStationModel.getWindVelocity();
    }

    public void setWindVelocity(double windVelocity){
        weatherStationModel.setWindVelocity(windVelocity);
    }

    public double getRainfallAmount() {
        return weatherStationModel.getRainfallAmount();
    }

    public void setRainfallAmount(double rainfallAmount){
        weatherStationModel.setRainfallAmount(rainfallAmount);
    }

    public double getAirHumidity() {
        return weatherStationModel.getAirHumidity();
    }

    public void setAirHumidity(double airHumidity){
        weatherStationModel.setAirHumidity(airHumidity);
    }

    public double getAirPressure() {
        return weatherStationModel.getAirPressure();
    }

    public void setAirPressure(double airPressure){
        weatherStationModel.setAirPressure(airPressure);
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
