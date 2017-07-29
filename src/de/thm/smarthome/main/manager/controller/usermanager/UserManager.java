package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.connection.database.user.UserDAO;
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
    public MessageBean login(String username, String password){
        return userdao.logUserIn(username, password);
    }

    @Override
    public MessageBean logout(String username){
        return userdao.logUserOut(username);
    }

    @Override
    public MessageBean checkLogin(String username) {
        return userdao.isUserloggedIn(username);
    }

    @Override
    public boolean isLoggedIn(String username){
        switch(userdao.isUserloggedIn(username).getMessageCode_Enum()){
            case LOGGEDIN:
                return true;
            default:
                return false;
        }
    }

    @Override
    public MessageBean createUser(String username, String password, String firstname, String lastname, String email) {
        return null;
    }

    @Override
    public UserTransferObject getUserData(String username) {
        return null;
    }

    @Override
    public UserTransferObject[] getAllUserData() {
        return new UserTransferObject[0];
    }

    @Override
    public MessageBean deleteUser(String username) {
        return null;
    }

    @Override
    public MessageBean alterUser(String username, String password, String firstname, String lastname, String email) {
        return null;
    }
}
