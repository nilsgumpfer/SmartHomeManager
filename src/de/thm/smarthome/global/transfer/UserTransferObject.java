package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.helper.MessageRepository;

/**
 * Created by Nils on 05.02.2017.
 */
public class UserTransferObject {
    private ResponseCode responseCode;
    private String message;

    public UserTransferObject(ResponseCode responseCode) {
        this.responseCode = responseCode;
        message = MessageRepository.getMessage(responseCode);
    }

    public UserTransferObject(User user) {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}
