package de.thm.smarthome.global.connection.database.user;

import java.util.List;

/**
 * Created by Nils on 04.02.2017.
 */
public class UserDAO {
    public User getUserByUserName(String username){return null;}
    public User getUserByFirstNameAndLastName(String firstname, String lastname){return null;}
    public int logUserIn(User user){return 0;}
    public int logUserOut(User user){return 0;}
    public List<User> getAllUsers(){return null;}
    public List<User> getAllLoggedInUsers(){return null;}
    public List<User> getAllLoggedOutUsers(){return null;}
}
