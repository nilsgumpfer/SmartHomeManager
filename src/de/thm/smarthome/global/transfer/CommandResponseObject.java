package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class CommandResponseObject {
    private ResponseCode responseCode;
    private String message;

    public CommandResponseObject(ResponseCode responseCode){
        this.responseCode   = responseCode;
        message             = MessageRepository.getMessage(responseCode);
    }
}
