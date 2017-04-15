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

    public ResponseCode login(User user){
        return userdao.logUserIn(user);
    }

    public ResponseCode logout(User user){
        return userdao.logUserOut(user);
    }

    @Override
    public ResponseCode checkLogin(User user) {
        return userdao.isUserloggedIn(user);
    }

    @Override
    public ResponseCode login(UserTransferObject userTransferObject) {
        return login(userTransferObject.getUser());
    }

    @Override
    public ResponseCode logout(UserTransferObject userTransferObject) {
        return logout(userTransferObject.getUser());
    }

    public boolean isLoggedIn(User user){
        switch(userdao.isUserloggedIn(user)){
            case LoggedIn:
                return true;
            default:
                return false;
        }
    }

    public boolean isLoggedOut(User user){
        return !isLoggedIn(user);
    }

    @Override
    public boolean isLoggedIn(UserTransferObject userTransferObject) {
        return isLoggedIn(userTransferObject.getUser());
    }

    @Override
    public boolean isLoggedOut(UserTransferObject userTransferObject) {
        return isLoggedOut(userTransferObject.getUser());
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
    public CommandResponseObject deleteUser(UserTransferObject userTransferObject) {
        return null;
    }

    @Override
    public CommandResponseObject alterUser(UserTransferObject userTransferObject) {
        return null;
    }

    public ResponseCode checkLogin(UserTransferObject userTransferObject){
        return checkLogin(userTransferObject.getUser());
    }
}
