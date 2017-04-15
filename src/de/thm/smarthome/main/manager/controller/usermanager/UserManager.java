package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.connection.database.user.UserDAO;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.CommandResponseObject;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class UserManager implements IUserManager{
    private static UserManager ourInstance = new UserManager();

    private List<User> loggedInUsers;
    private List<User> allUsers;
    UserDAO userdao = new UserDAO();

    private UserManager() {
    }

    public static UserManager getInstance() {
        return ourInstance;
    }

    @Override
    public ResponseCode login(String username){
        return userdao.logUserIn(username);
    }

    @Override
    public ResponseCode logout(String username){
        return userdao.logUserOut(username);
    }

    @Override
    public ResponseCode checkLogin(String username) {
        return userdao.isUserloggedIn(username);
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
        switch(userdao.isUserloggedIn(username)){
            case LoggedIn:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean isLoggedOut(String username){
        return !isLoggedIn(username);
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
        return null;
    }

    @Override
    public UserTransferObject getUserData(UserTransferObject userTransferObject) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public UserTransferObject[] getAllUserData() {
        return new UserTransferObject[0];
    }

    @Override
    public CommandResponseObject deleteUser(UserTransferObject userTransferObject) {
        return null;
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject userTransferObject) {
        return null;
    }

    public ResponseCode checkLogin(UserTransferObject userTransferObject){
        return checkLogin(userTransferObject.getUsername());
    }
}
