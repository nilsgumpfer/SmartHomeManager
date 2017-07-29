package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.transfer.UserTransferObject;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IUserManager {
    MessageBean login(String username, String password);
    MessageBean logout(String username);
    MessageBean checkLogin(String username);

    MessageBean deleteUser(String username);

    MessageBean alterUser(String username, String password, String firstname, String lastname, String email);

    boolean isLoggedIn(String username);

    MessageBean createUser(String username, String password, String firstname, String lastname, String email);

    UserTransferObject getUserData(String username);

    UserTransferObject[] getAllUserData();
}
