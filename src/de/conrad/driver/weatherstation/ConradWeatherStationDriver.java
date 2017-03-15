package de.conrad.driver.weatherstation;

/**
 * Created by Nils on 27.01.2017.
 */
public class ConradWeatherStationDriver {
    private String serialnumber;
    private double temperature;
    private double windVelocity;
    private double airPressure;
    private double rainfallAmount;

    public ConradWeatherStationDriver(String productSerialNumber){

        //TODO: Invoke command remotely at station!
        this.serialnumber = productSerialNumber;
        this.temperature = 6.58;
        this.windVelocity = 33.5;
        this.airPressure = 1203.44;
        this.rainfallAmount = 30.1;
    }

    public double getTemperature(){

        //TODO: Invoke command remotely at station!
        return temperature;
    };

    public double getWindVelocity() {

        //TODO: Invoke command remotely at station!
        return windVelocity;
    }

    public double getAirPressure() {

        //TODO: Invoke command remotely at station!
        return airPressure;
    }

    public double getRainfallAmount() {

        //TODO: Invoke command remotely at station!
        return rainfallAmount;
    }

}
