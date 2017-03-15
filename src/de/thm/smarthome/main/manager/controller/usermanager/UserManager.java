package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;

import java.util.List;

/**
 * Created by Nils on 27.01.2017.
 */
public class UserManager implements IUserManager{
    private static UserManager ourInstance = new UserManager();

    private List<User> loggedInUsers;
    private List<User> allUsers;

    private UserManager() {
    }

    public static UserManager getInstance() {
        return ourInstance;
    }

    public int Login(User user){
        return 0;
    }

    public int Logout(User user){
        return 0;
    }

    public boolean isLoggedIn(User user){
        return false;
    }

    public boolean isLoggedOut(User user){
        return !(isLoggedIn(user));
    }
}
