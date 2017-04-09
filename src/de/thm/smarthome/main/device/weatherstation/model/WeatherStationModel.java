package de.thm.smarthome.main.device.weatherstation.model;

/**
 * Created by Nils on 27.01.2017.
 */
public class WeatherStationModel implements IWeatherStationModel{
    private double windVelocity = 0.5;
    private double rainfallAmount = 20;
    private double airHumidity = 2;
    private double airPressure = 4;
    private double temperature = 13;
    private boolean isMetric = false;


    @Override
    public double getWindVelocity() {
        return windVelocity;
    }

    @Override
    public void setWindVelocity(double windVelocity) {
        this.windVelocity = windVelocity;
    }

    @Override
    public double getRainfallAmount() {
        return rainfallAmount;
    }

    @Override
    public void setRainfallAmount(double rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }

    @Override
    public double getAirHumidity() {
        return 0;
    }

    @Override
    public void setAirHumidity(double airHumidity) {
        this.airHumidity = airHumidity;
    }

    @Override
    public double getAirPressure() {
        return airPressure;
    }

    @Override
    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean isMetric() {
        if(isMetric){
            return true;
        }
        return false;
    }

    @Override
    public void toggleMeasuringUnit() {
        if(isMetric){
            isMetric = false;
        } else{
            isMetric = true;
        }

    }
}
