package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class WeatherStationTransferObject {
    private ResponseCode responseCode;
    private String message;
    private double windVelocity;
    private UnitOfMeasurement windVelocityUnit;
    private double airPressure;
    private UnitOfMeasurement airPressureUnit;
    private double outdoorTemperature;
    private UnitOfMeasurement outdoorTemperatureUnit;
    private double rainfallAmount;
    private UnitOfMeasurement rainfallAmountUnit;
    private double airHumidity;
    private UnitOfMeasurement airHumidityUnit;

    private WeatherStationTransferObject(){}

    public WeatherStationTransferObject(ResponseCode responseCode) {
        this.responseCode = responseCode;
        message = MessageRepository.getMessage(responseCode);
    }

    public WeatherStationTransferObject(
        double windVelocity,
        UnitOfMeasurement windVelocityUnit,
        double airPressure,
        UnitOfMeasurement airPressureUnit,
        double outdoorTemperature,
        UnitOfMeasurement outdoorTemperatureUnit,
        double rainfallAmount,
        UnitOfMeasurement rainfallAmountUnit,
        double airHumidity,
        UnitOfMeasurement airHumidityUnit
        ){
        this.windVelocity = windVelocity;
        this.windVelocityUnit = windVelocityUnit;
        this.airPressure = airPressure;
        this.airPressureUnit = airPressureUnit;
        this.outdoorTemperature = outdoorTemperature;
        this.outdoorTemperatureUnit = outdoorTemperatureUnit;
        this.rainfallAmount = rainfallAmount;
        this.rainfallAmountUnit = rainfallAmountUnit;
        this.airHumidity = airHumidity;
        this.airHumidityUnit = airHumidityUnit;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(double windVelocity) {
        this.windVelocity = windVelocity;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }

    public double getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public void setOutdoorTemperature(double outdoorTemperature) {
        this.outdoorTemperature = outdoorTemperature;
    }

    public double getRainfallAmount() {
        return rainfallAmount;
    }

    public void setRainfallAmount(double rainfallAmount) {
        this.rainfallAmount = rainfallAmount;
    }

    public double getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(double airHumidity) {
        this.airHumidity = airHumidity;
    }

    @Override
    public String toString(){
        return "weatherstation: " + " windv: " + windVelocity + " windv_u: " + windVelocityUnit + " airpr: " + airPressure + " airpr_u: " + airPressureUnit+ " temp: " + outdoorTemperature + " temp_u: " + outdoorTemperatureUnit + " rainf: " + rainfallAmount + " rainf_u: " + rainfallAmountUnit + " airhum: " + airHumidity + " airhum_u: " + airHumidityUnit + " resp: " + responseCode + " : " + message;
    }
}
