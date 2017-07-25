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
    public MessageBean login(String username){
        return userdao.logUserIn(username);
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
    public MessageBean login(UserTransferObject userTransferObject) {
        return login(userTransferObject.getUsername());
    }

    @Override
    public MessageBean logout(UserTransferObject userTransferObject) {
        return logout(userTransferObject.getUsername());
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
    public boolean isLoggedOut(String username){
        return !isLoggedIn(username);
    }

    @Override
    public MessageBean createUser(UserTransferObject userTransferObject) {
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
    public MessageBean deleteUser(UserTransferObject userTransferObject) {
        return null;
    }

    @Override
    public MessageBean alterUser(UserTransferObject userTransferObject) {
        return null;
    }
}
