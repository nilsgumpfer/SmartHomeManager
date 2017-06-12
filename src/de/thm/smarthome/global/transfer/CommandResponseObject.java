package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class CommandResponseObject {
    private EMessageCode responseCode;
    private String message;

    private CommandResponseObject(){}

    public CommandResponseObject(EMessageCode responseCode){
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
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

    @Override
    public String toString(){
        return "resp: " + responseCode + " : " + message;
    }
}
