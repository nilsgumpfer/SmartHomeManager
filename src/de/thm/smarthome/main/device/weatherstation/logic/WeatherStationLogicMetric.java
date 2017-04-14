package de.thm.smarthome.main.device.weatherstation.logic;

import de.thm.smarthome.main.device.weatherstation.adapter.IWeatherStation;
import de.thm.smarthome.main.device.weatherstation.model.IWeatherStationModel;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationLogicMetric implements IWeatherStationLogic {
    private IWeatherStationModel model;
    private IWeatherStation device;

    public WeatherStationLogicMetric(IWeatherStationModel model, IWeatherStation device) {
        this.model = model;
        this.device = device;
        if(model.isMetric()==false){
            model.toggleMeasuringUnit();
        }
    }

    @Override
    public void setValues() {
        if(model.isMetric()==false){
            model.setAirHumidity(model.getAirHumidity());
            model.setAirPressure(model.getAirPressure() / 14.503773773);
            model.setRainfallAmount(model.getRainfallAmount() / 1.75289575289575);
            model.setTemperature((model.getTemperature() - 32) / 1.8);
            model.setWindVelocity(model.getWindVelocity() * 1.60934);
            model.toggleMeasuringUnit();
        } else {
            //TODO: //Fehlermeldung: "Die Wetterstation verwendet bereits Anglo-Amerikanische Einheiten!"
        }
    }
}
