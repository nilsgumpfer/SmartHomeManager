package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.transfer.CommandResponseObject;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.util.List;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IUserManager {
    EMessageCode login(String username);
    EMessageCode logout(String username);
    EMessageCode checkLogin(String username);
    EMessageCode login(UserTransferObject userTransferObject);
    EMessageCode logout(UserTransferObject userTransferObject);

    CommandResponseObject deleteUser(UserTransferObject userTransferObject);

    CommandResponseObject alterUser(UserTransferObject userTransferObject);

    EMessageCode checkLogin(UserTransferObject userTransferObject);
    boolean isLoggedIn(String username);
    boolean isLoggedOut(String username);
    boolean isLoggedIn(UserTransferObject userTransferObject);
    boolean isLoggedOut(UserTransferObject userTransferObject);

    CommandResponseObject createUser(UserTransferObject userTransferObject);

    UserTransferObject getUserData(UserTransferObject userTransferObject);

    List<User> getAllUsers();

    UserTransferObject[] getAllUserData();
}
