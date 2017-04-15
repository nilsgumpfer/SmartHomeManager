package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;

/**
 * Created by Nils on 05.02.2017.
 */
public class UserTransferObject {
    public String var1;
    public int int1;

    public UserTransferObject(ResponseCode responseCode) {
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
