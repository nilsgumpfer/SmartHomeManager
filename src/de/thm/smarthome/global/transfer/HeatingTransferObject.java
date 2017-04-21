package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;
import de.thm.smarthome.global.enumeration.Power;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.helper.ManufacturerRepository;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.global.helper.UnitRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class HeatingTransferObject {
    private ResponseCode responseCode;

    private String message;

    private String heatingName;
    private double temperature;
    private UnitOfMeasurement temperatureUnit;
    private DeviceManufacturer manufacturer;
    private String manufacturer_t;
    private String unit_t;
    private Power powerState;
    private String powerState_t;
    private String model;
    private String mode;
    private String serialnumber;

    private HeatingTransferObject(){}

    public HeatingTransferObject(ResponseCode responseCode){
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }

    public HeatingTransferObject(double temperature, UnitOfMeasurement temperatureUnit){
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
    }

    public HeatingTransferObject(String heatingName, double temperature) {
        this.heatingName    = heatingName;
        this.temperature    = temperature;
    }

    public HeatingTransferObject(DeviceManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getMessage(){
        return message;
    }

    public String getHeatingName(){
        return heatingName;
    }

    public ResponseCode getResponseCode(){
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeatingName(String heatingName) {
        this.heatingName = heatingName;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public UnitOfMeasurement getTemperatureUnit() {
        return temperatureUnit;
    }

    public String getManufacturer_t() {
        return manufacturer_t;
    }

    public void setManufacturer_t(String manufacturer_t) {
        this.manufacturer_t = manufacturer_t;
    }

    public String getUnit_t() {
        return unit_t;
    }

    public void setUnit_t(String unit_t) {
        this.unit_t = unit_t;
    }

    public void setTemperatureUnit(UnitOfMeasurement temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public void setManufacturer(DeviceManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public DeviceManufacturer getManufacturer() {
        return manufacturer;
    }

    public Power getPowerState() {
        return powerState;
    }

    public void setPowerState(Power powerState) {
        this.powerState = powerState;
    }

    public String getPowerState_t() {
        return powerState_t;
    }

    public void setPowerState_t(String powerState_t) {
        this.powerState_t = powerState_t;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    @Override
    public String toString(){
        return "heatingName: " + heatingName + " temp: " + temperature + " manuf: " + manufacturer + " resp: " + responseCode + " : " + message;
    }
}
