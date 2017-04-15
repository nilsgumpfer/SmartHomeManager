package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.CommandResponseObject;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IUserManager {
    ResponseCode login(String username);
    ResponseCode logout(String username);
    ResponseCode checkLogin(String username);
    ResponseCode login(UserTransferObject userTransferObject);
    ResponseCode logout(UserTransferObject userTransferObject);

    CommandResponseObject deleteUser(UserTransferObject userTransferObject);

    CommandResponseObject alterUser(UserTransferObject userTransferObject);

    ResponseCode checkLogin(UserTransferObject userTransferObject);
    boolean isLoggedIn(String username);
    boolean isLoggedOut(String username);
    boolean isLoggedIn(UserTransferObject userTransferObject);
    boolean isLoggedOut(UserTransferObject userTransferObject);

    CommandResponseObject createUser(UserTransferObject userTransferObject);

    UserTransferObject getUserData(UserTransferObject userTransferObject);

    List<User> getAllUsers();

    UserTransferObject[] getAllUserData();
}
