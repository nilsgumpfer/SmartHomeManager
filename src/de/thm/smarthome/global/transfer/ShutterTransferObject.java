package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;
import de.thm.smarthome.main.device.shutter.device.SmartShutter;

/**
 * Created by Nils on 05.02.2017.
 */
public class ShutterTransferObject {
    private ResponseCode responseCode;
    private String message;
    private int position;
    private String shutterID;

    public ShutterTransferObject(ResponseCode responseCode) {
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
}
