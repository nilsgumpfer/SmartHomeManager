package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.helper.ManufacturerRepository;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class WeatherStationTransferObject {
    private ResponseCode responseCode;
    private String message;
    private double windVelocity;
    private UnitOfMeasurement windVelocityUnit;
    private String windVelocityUnit_t;
    private double airPressure;
    private UnitOfMeasurement airPressureUnit;
    private String airPressureUnit_t;
    private double outdoorTemperature;
    private UnitOfMeasurement outdoorTemperatureUnit;
    private String outdoorTemperatureUnit_t;
    private double rainfallAmount;
    private UnitOfMeasurement rainfallAmountUnit;
    private String rainfallAmountUnit_t;
    private double airHumidity;
    private UnitOfMeasurement airHumidityUnit;
    private String airHumidityUnit_t;
    private DeviceManufacturer manufacturer;
    private String manufacturer_t;
    private String serialnumber;
    private String model;
    private String name;

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

    public WeatherStationTransferObject(double windVelocity, String windVelocityUnit_t, double airPressure, String airPressureUnit_t, double outdoorTemperature, String outdoorTemperatureUnit_t, double rainfallAmount, String rainfallAmountUnit_t, double airHumidity, String airHumidityUnit_t, String manufacturer_t, String serialnumber, String model, String name) {
        this.windVelocity = windVelocity;
        this.windVelocityUnit_t = windVelocityUnit_t;
        this.airPressure = airPressure;
        this.airPressureUnit_t = airPressureUnit_t;
        this.outdoorTemperature = outdoorTemperature;
        this.outdoorTemperatureUnit_t = outdoorTemperatureUnit_t;
        this.rainfallAmount = rainfallAmount;
        this.rainfallAmountUnit_t = rainfallAmountUnit_t;
        this.airHumidity = airHumidity;
        this.airHumidityUnit_t = airHumidityUnit_t;
        this.manufacturer_t = manufacturer_t;
        this.serialnumber = serialnumber;
        this.model = model;
        this.name = name;
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

    public DeviceManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(DeviceManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public UnitOfMeasurement getWindVelocityUnit() {
        return windVelocityUnit;
    }

    public void setWindVelocityUnit(UnitOfMeasurement windVelocityUnit) {
        this.windVelocityUnit = windVelocityUnit;
    }

    public String getWindVelocityUnit_t() {
        return windVelocityUnit_t;
    }

    public void setWindVelocityUnit_t(String windVelocityUnit_t) {
        this.windVelocityUnit_t = windVelocityUnit_t;
    }

    public UnitOfMeasurement getAirPressureUnit() {
        return airPressureUnit;
    }

    public void setAirPressureUnit(UnitOfMeasurement airPressureUnit) {
        this.airPressureUnit = airPressureUnit;
    }

    public String getAirPressureUnit_t() {
        return airPressureUnit_t;
    }

    public void setAirPressureUnit_t(String airPressureUnit_t) {
        this.airPressureUnit_t = airPressureUnit_t;
    }

    public UnitOfMeasurement getOutdoorTemperatureUnit() {
        return outdoorTemperatureUnit;
    }

    public void setOutdoorTemperatureUnit(UnitOfMeasurement outdoorTemperatureUnit) {
        this.outdoorTemperatureUnit = outdoorTemperatureUnit;
    }

    public String getOutdoorTemperatureUnit_t() {
        return outdoorTemperatureUnit_t;
    }

    public void setOutdoorTemperatureUnit_t(String outdoorTemperatureUnit_t) {
        this.outdoorTemperatureUnit_t = outdoorTemperatureUnit_t;
    }

    public UnitOfMeasurement getRainfallAmountUnit() {
        return rainfallAmountUnit;
    }

    public void setRainfallAmountUnit(UnitOfMeasurement rainfallAmountUnit) {
        this.rainfallAmountUnit = rainfallAmountUnit;
    }

    public String getRainfallAmountUnit_t() {
        return rainfallAmountUnit_t;
    }

    public void setRainfallAmountUnit_t(String rainfallAmountUnit_t) {
        this.rainfallAmountUnit_t = rainfallAmountUnit_t;
    }

    public UnitOfMeasurement getAirHumidityUnit() {
        return airHumidityUnit;
    }

    public void setAirHumidityUnit(UnitOfMeasurement airHumidityUnit) {
        this.airHumidityUnit = airHumidityUnit;
    }

    public String getAirHumidityUnit_t() {
        return airHumidityUnit_t;
    }

    public void setAirHumidityUnit_t(String airHumidityUnit_t) {
        this.airHumidityUnit_t = airHumidityUnit_t;
    }

    public String getManufacturer_t() {
        return manufacturer_t;
    }

    public void setManufacturer_t(String manufacturer_t) {
        this.manufacturer_t = manufacturer_t;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "weatherstation: " + " windv: " + windVelocity + " windv_u: " + windVelocityUnit + " airpr: " + airPressure + " airpr_u: " + airPressureUnit+ " temp: " + outdoorTemperature + " temp_u: " + outdoorTemperatureUnit + " rainf: " + rainfallAmount + " rainf_u: " + rainfallAmountUnit + " airhum: " + airHumidity + " airhum_u: " + airHumidityUnit + " resp: " + responseCode + " : " + message;
    }
}
