package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.DeviceManufacturer;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class HeatingTransferObject {
    private ResponseCode responseCode;
    private String message;
    private String heatingName;
    private double temperature;
    private DeviceManufacturer manufacturer;

    public HeatingTransferObject(ResponseCode responseCode){
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }

    public HeatingTransferObject(double temperature){
        this.temperature = temperature;
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

    public DeviceManufacturer getManufacturer() {
        return manufacturer;
    }
}
