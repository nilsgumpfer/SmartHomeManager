package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.connection.database.user.User;

/**
 * Created by Nils on 05.02.2017.
 */
public class UserTransferObject {
    public String var1;
    public int int1;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

}
