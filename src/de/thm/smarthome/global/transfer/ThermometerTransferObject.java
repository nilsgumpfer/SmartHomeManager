package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UnitOfMeasurement;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.main.device.thermometer.device.Thermometer;

/**
 * Created by Nils on 05.02.2017.
 */
public class ThermometerTransferObject {
    private ResponseCode responseCode;
    private String message;
    private double temperature;
    private UnitOfMeasurement temperatureUnit;

    private ThermometerTransferObject(){}

    public ThermometerTransferObject(ResponseCode responseCode) {
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }

    public ThermometerTransferObject(double temperature, UnitOfMeasurement temperatureUnit) {
        this.temperature        = temperature;
        this.temperatureUnit    = temperatureUnit;
    }

    public ThermometerTransferObject(UnitOfMeasurement temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    @Override
    public String toString(){
        return "thermometer: " + " temp: " + temperature + " unit: " + temperatureUnit + " resp:" + responseCode + " : " + message;
    }
}
