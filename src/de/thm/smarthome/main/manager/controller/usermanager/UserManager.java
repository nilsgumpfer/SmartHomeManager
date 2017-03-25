package de.thm.smarthome.main.manager.controller.usermanager;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.connection.database.user.UserDAO;

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

    public int Login(User user) throws SQLException{
        userdao.logUserIn(user);
        return 0;
    }

    public int Logout(User user)throws SQLException{
        userdao.logUserOut(user);
        return 0;
    }

    public boolean isLoggedIn(User user)throws SQLException{
            return userdao.isUserloggedIn(user);
    }

    public boolean isLoggedOut(User user)throws SQLException{
        return !(isLoggedIn(user));
    }
}
