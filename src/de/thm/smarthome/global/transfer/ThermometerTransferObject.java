package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EUnitOfMeasurement;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.helper.UnitRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class ThermometerTransferObject {
    private EMessageCode responseCode;
    private String message;
    private double temperature;
    private EUnitOfMeasurement temperatureUnit;
    private String temperatureUnit_t;
    private EDeviceManufacturer manufacturer;
    private String manufacturer_t;
    private String model;
    private String serialnumber;
    private String name;

    private ThermometerTransferObject(){}

    public ThermometerTransferObject(EMessageCode responseCode) {
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }

    public ThermometerTransferObject(double temperature, EUnitOfMeasurement temperatureUnit) {
        this.temperature        = temperature;
        this.temperatureUnit    = temperatureUnit;
    }

    public ThermometerTransferObject(double temperature, String temperatureUnit_t) {
        this.temperature        = temperature;
        this.temperatureUnit_t   = temperatureUnit_t;
    }

    public ThermometerTransferObject(String name, String manufacturer_t, String model, String serialnumber, double temperature, String temperatureUnit_t) {
        this.name = name;
        this.manufacturer_t = manufacturer_t;
        this.model = model;
        this.serialnumber = serialnumber;
        this.temperature = temperature;
        this.temperatureUnit_t = temperatureUnit_t;
    }

    public ThermometerTransferObject(EUnitOfMeasurement temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public EMessageCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(EMessageCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public EUnitOfMeasurement getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(EUnitOfMeasurement temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTemperatureUnitAsText() {
        return UnitRepository.getUnitAsText(temperatureUnit);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EDeviceManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(EDeviceManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer_t() {
        return manufacturer_t;
    }

    public void setManufacturer_t(String manufacturer_t) {
        this.manufacturer_t = manufacturer_t;
    }

    public String getTemperatureUnit_t() {
        return temperatureUnit_t;
    }

    public void setTemperatureUnit_t(String temperatureUnit_t) {
        this.temperatureUnit_t = temperatureUnit_t;
    }

    @Override
    public String toString(){
        return "thermometer: " + " temp: " + temperature + " unit: " + temperatureUnit + " resp:" + responseCode + " : " + message;
    }
}
