package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.connection.database.user.UserDAO;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.enumeration.UserGroup;
import de.thm.smarthome.global.transfer.CommandResponseObject;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 15.04.2017.
 */
public class UserManagerMock implements IUserManager{
    private static UserManagerMock ourInstance = new UserManagerMock();

    private UserManagerMock() {
    }

    public static UserManagerMock getInstance() {
        return ourInstance;
    }

    @Override
    public ResponseCode login(String username){
        return ResponseCode.LoginSuccessful;
    }

    @Override
    public ResponseCode logout(String username){
        return ResponseCode.LogoutSuccessful;
    }

    @Override
    public ResponseCode checkLogin(String username) {
        return ResponseCode.LoggedIn;
    }

    @Override
    public ResponseCode login(UserTransferObject userTransferObject) {
        return login(userTransferObject.getUsername());
    }

    @Override
    public ResponseCode logout(UserTransferObject userTransferObject) {
        return logout(userTransferObject.getUsername());
    }

    @Override
    public boolean isLoggedIn(String username){
        return true;
    }

    @Override
    public boolean isLoggedOut(String username){
        return true;
    }

    @Override
    public boolean isLoggedIn(UserTransferObject userTransferObject) {
        return isLoggedIn(userTransferObject.getUsername());
    }

    @Override
    public boolean isLoggedOut(UserTransferObject userTransferObject) {
        return isLoggedOut(userTransferObject.getUsername());
    }

    @Override
    public CommandResponseObject createUser(UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.UserCreatedSuccessfully);
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject userTransferObject) {
        return new UserTransferObject("username", "password", "firstname", "lastname", "eMail" , UserGroup.Administrator);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    @Override
    public UserTransferObject[] getAllUserData() {
        return new UserTransferObject[0];
    }

    @Override
    public CommandResponseObject deleteUser(UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.UserDeletedSuccessfully);
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject userTransferObject) {
        return new CommandResponseObject(ResponseCode.UserAlteredSuccessfully);
    }

    public ResponseCode checkLogin(UserTransferObject userTransferObject){
        return checkLogin(userTransferObject.getUsername());
    }
}
