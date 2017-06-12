package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.EMessageCode;
import de.thm.smarthome.global.enumeration.EUserGroup;
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
    public EMessageCode login(String username){
        return EMessageCode.LoginSuccessful;
    }

    @Override
    public EMessageCode logout(String username){
        return EMessageCode.LogoutSuccessful;
    }

    @Override
    public EMessageCode checkLogin(String username) {
        return EMessageCode.LoggedIn;
    }

    @Override
    public EMessageCode login(UserTransferObject userTransferObject) {
        return login(userTransferObject.getUsername());
    }

    @Override
    public EMessageCode logout(UserTransferObject userTransferObject) {
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
        return new CommandResponseObject(EMessageCode.UserCreatedSuccessfully);
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject userTransferObject) {
        return new UserTransferObject("username", "password", "firstname", "lastname", "eMail" , EUserGroup.Administrator);
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
        return new CommandResponseObject(EMessageCode.UserDeletedSuccessfully);
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject userTransferObject) {
        return new CommandResponseObject(EMessageCode.UserAlteredSuccessfully);
    }

    public EMessageCode checkLogin(UserTransferObject userTransferObject){
        return checkLogin(userTransferObject.getUsername());
    }
}
