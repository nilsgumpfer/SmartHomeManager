package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Nils on 01.02.2017.
 */
public interface IUserManager {
    ResponseCode Login(User user);
    ResponseCode Logout(User user);
    ResponseCode checkLogin(User user);
    ResponseCode Login(UserTransferObject userTransferObject);
    ResponseCode Logout(UserTransferObject userTransferObject);
    ResponseCode checkLogin(UserTransferObject userTransferObject);
    boolean isLoggedIn(User user);
    boolean isLoggedOut(User user);
    boolean isLoggedIn(UserTransferObject userTransferObject);
    boolean isLoggedOut(UserTransferObject userTransferObject);
}
