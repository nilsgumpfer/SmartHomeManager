package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.connection.database.user.UserDAO;
import de.thm.smarthome.global.enumeration.ResponseCode;
import de.thm.smarthome.global.transfer.UserTransferObject;

import java.sql.SQLException;
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

    public ResponseCode Login(User user){
        return userdao.logUserIn(user);
    }

    public ResponseCode Logout(User user){
        return userdao.logUserOut(user);
    }

    @Override
    public ResponseCode checkLogin(User user) {
        return userdao.isUserloggedIn(user);
    }

    @Override
    public ResponseCode Login(UserTransferObject userTransferObject) {
        return Login(userTransferObject.getUser());
    }

    @Override
    public ResponseCode Logout(UserTransferObject userTransferObject) {
        return Logout(userTransferObject.getUser());
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

    public ResponseCode checkLogin(UserTransferObject userTransferObject){
        return checkLogin(userTransferObject.getUser());
    }
}
