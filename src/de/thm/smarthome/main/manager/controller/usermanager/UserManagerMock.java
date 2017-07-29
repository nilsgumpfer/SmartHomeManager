package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.beans.UserGroupBean;
import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.EUserGroup;
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
    public MessageBean login(String username, String password){
        return new MessageBean(true);
    }

    @Override
    public MessageBean logout(String username){
        return new MessageBean(true);
    }

    @Override
    public MessageBean checkLogin(String username) {
        return new MessageBean(true);
    }

    @Override
    public boolean isLoggedIn(String username){
        return true;
    }

    @Override
    public MessageBean createUser(String username, String password, String firstname, String lastname, String email) {
        return new MessageBean(true);
    }

    @Override
    public UserTransferObject getUserData(String username) {
        return new UserTransferObject("_username_", "_password_", "_firstname_", "_lastname_", "_eMail_" , new UserGroupBean(EUserGroup.ADMINISTRATOR));
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
    public MessageBean deleteUser(String username) {
        return new MessageBean(true);
    }

    @Override
    public MessageBean alterUser(String username, String password, String firstname, String lastname, String email) {
        return new MessageBean(true);
    }
}
