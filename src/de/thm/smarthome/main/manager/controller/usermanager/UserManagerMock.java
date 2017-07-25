package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.beans.MessageBean;
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
    public MessageBean login(String username){
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
    public MessageBean login(UserTransferObject userTransferObject) {
        return login(userTransferObject.getUsername());
    }

    @Override
    public MessageBean logout(UserTransferObject userTransferObject) {
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
    public MessageBean createUser(UserTransferObject userTransferObject) {
        return new MessageBean(true);
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
    public MessageBean deleteUser(UserTransferObject userTransferObject) {
        return new MessageBean(true);
    }

    @Override
    public MessageBean alterUser(UserTransferObject userTransferObject) {
        return new MessageBean(true);
    }
}
