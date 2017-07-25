package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.util.List;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IUserManager {
    MessageBean login(String username);
    MessageBean logout(String username);
    MessageBean checkLogin(String username);
    MessageBean login(UserTransferObject userTransferObject);
    MessageBean logout(UserTransferObject userTransferObject);

    MessageBean deleteUser(UserTransferObject userTransferObject);

    MessageBean alterUser(UserTransferObject userTransferObject);

    boolean isLoggedIn(String username);
    boolean isLoggedOut(String username);

    MessageBean createUser(UserTransferObject userTransferObject);

    UserTransferObject getUserData(UserTransferObject userTransferObject);

    List<User> getAllUsers();

    UserTransferObject[] getAllUserData();
}
