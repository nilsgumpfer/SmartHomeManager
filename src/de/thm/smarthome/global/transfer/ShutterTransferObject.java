package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.EDeviceManufacturer;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class ShutterTransferObject {
    private EMessageCode responseCode;
    private String message;
    private int position;
    private String shutterID;
    private EDeviceManufacturer manufacturer;
    private String manufacturer_t;
    private String model;
    private String shutterName;
    private String serialnumber;
    private boolean moveComplete;

    private ShutterTransferObject(){}

    public ShutterTransferObject(EMessageCode responseCode) {
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }

    public ShutterTransferObject(int position) {
        this.position = position;
    }

    public ShutterTransferObject(int position, String shutterID) {
        this.position   = position;
        this.shutterID  = shutterID;
    }

    public ShutterTransferObject(String shuttername, String manufacturer_t, String model, String serialnumber, int position) {
        this.shutterName = shuttername;
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialnumber = serialnumber;
        this.position = position;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getShutterID() {
        return shutterID;
    }

    public void setShutterID(String shutterID) {
        this.shutterID = shutterID;
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

    public boolean isMoveComplete() {
        return moveComplete;
    }

    public void setMoveComplete(boolean moveComplete) {
        this.moveComplete = moveComplete;
    }

    @Override
    public String toString(){
        return "shutterID: " + shutterID + " pos: " + position + " resp:" + responseCode + " : " + message;
    }
}
