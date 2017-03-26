package de.thm.smarthome.global.connection.database.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils on 04.02.2017.
 */
public class UserDAO {

    public ResultSet UserEinlesen(String username, String firstname, String lastname) throws SQLException {
        MySQLConnection mysqlconn = new MySQLConnection();
        ResultSet res;
        PreparedStatement ps = mysqlconn.conn.prepareStatement("Select * from users where username like ? and firstname like ? and lastname like ?");
        ps.setString(1, username);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        res=ps.executeQuery();
        return res;
    }

    public User getUserByUserName(String username)throws SQLException{
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String usrname;
        String firstname;
        String lastname;
        String password;
        String lastTimeLoggedIn;
        boolean loggedIn;

        User currentUser = new User();
        currentUser.setUsername("0");
        currentUser.setFirstname("0");
        currentUser.setLastname("0");
        currentUser.setPassword("0");
        currentUser.setLastTimeLoggedIn("1970-01-01");
        currentUser.setLoggedIn(false);

        try{
            ResultSet rs = UserEinlesen(username+"%", "%", "%");
                    while (rs.next()){
                        usrname = rs.getString(2);
                        firstname = rs.getString(3);
                        lastname = rs.getString(4);
                        password = rs.getString(5);
                        lastTimeLoggedIn = rs.getString(6);
                        loggedIn = rs.getBoolean(7);

                    currentUser.setUsername(usrname);
                    currentUser.setFirstname(firstname);
                    currentUser.setLastname(lastname);
                    currentUser.setPassword(password);
                    currentUser.setLastTimeLoggedIn(lastTimeLoggedIn);
                    currentUser.setLoggedIn(loggedIn);

                    return currentUser;
                    }
            } catch (SQLException e) {
            e.printStackTrace();
        }
    return currentUser;
    }

    public User getUserByFirstNameAndLastName(String firstname, String lastname)throws SQLException{
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String usrname;
        String first_name;
        String last_name;
        String password;
        String lastTimeLoggedIn;
        boolean loggedIn;

        User currentUser = new User();
        currentUser.setUsername("0");
        currentUser.setFirstname("0");
        currentUser.setLastname("0");
        currentUser.setPassword("0");
        currentUser.setLastTimeLoggedIn("1970-01-01");
        currentUser.setLoggedIn(false);

        try{
            ResultSet rs = UserEinlesen("%", firstname+"%", lastname+"%");
            while (rs.next()){
                usrname = rs.getString(2);
                first_name = rs.getString(3);
                last_name = rs.getString(4);
                password = rs.getString(5);
                lastTimeLoggedIn = rs.getString(6);
                loggedIn = rs.getBoolean(7);

                currentUser.setUsername(usrname);
                currentUser.setFirstname(first_name);
                currentUser.setLastname(last_name);
                currentUser.setPassword(password);
                currentUser.setLastTimeLoggedIn(lastTimeLoggedIn);
                currentUser.setLoggedIn(loggedIn);

                return currentUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentUser;
    }

    public int logUserIn(User user) throws SQLException {
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String currentUsername = user.getUsername();

        ResultSet res;
        Statement stm = mysqlconn.getConn().createStatement();
        res=stm.executeQuery("Update users SET loggedIn = true WHERE username ="+currentUsername);
        return 0;
    }

    public int logUserOut(User user) throws SQLException {
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String currentUsername = user.getUsername();

        ResultSet res;
        Statement stm = mysqlconn.getConn().createStatement();
        res=stm.executeQuery("Update users SET loggedIn = false WHERE username ="+currentUsername);
        return 0;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userlist = new ArrayList<User>();

        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String usrname;
        String firstname;
        String lastname;
        String password;
        String lastTimeLoggedIn;
        boolean loggedIn;

        User currentUser = new User();
        currentUser.setUsername("0");
        currentUser.setFirstname("0");
        currentUser.setLastname("0");
        currentUser.setPassword("0");
        currentUser.setLastTimeLoggedIn("1970-01-01");
        currentUser.setLoggedIn(false);

        try{
            ResultSet rs = UserEinlesen("%", "%", "%");
            while (rs.next()){
                usrname = rs.getString(2);
                firstname = rs.getString(3);
                lastname = rs.getString(4);
                password = rs.getString(5);
                lastTimeLoggedIn = rs.getString(6);
                loggedIn = rs.getBoolean(7);

                currentUser.setUsername(usrname);
                currentUser.setFirstname(firstname);
                currentUser.setLastname(lastname);
                currentUser.setPassword(password);
                currentUser.setLastTimeLoggedIn(lastTimeLoggedIn);
                currentUser.setLoggedIn(loggedIn);

                userlist.add(currentUser);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userlist;
    }

    public List<User> getAllLoggedInUsers() throws SQLException {
        List<User> userlist = new ArrayList<User>();

        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String usrname;
        String firstname;
        String lastname;
        String password;
        String lastTimeLoggedIn;
        boolean loggedIn;

        User currentUser = new User();
        currentUser.setUsername("0");
        currentUser.setFirstname("0");
        currentUser.setLastname("0");
        currentUser.setPassword("0");
        currentUser.setLastTimeLoggedIn("1970-01-01");
        currentUser.setLoggedIn(false);

        ResultSet res;
        Statement stm = mysqlconn.getConn().createStatement();
        res= stm.executeQuery("Select * from users where loggedIn = true");

        try{
            while (res.next()){
                usrname = res.getString(2);
                firstname = res.getString(3);
                lastname = res.getString(4);
                password = res.getString(5);
                lastTimeLoggedIn = res.getString(6);
                loggedIn = res.getBoolean(7);

                currentUser.setUsername(usrname);
                currentUser.setFirstname(firstname);
                currentUser.setLastname(lastname);
                currentUser.setPassword(password);
                currentUser.setLastTimeLoggedIn(lastTimeLoggedIn);
                currentUser.setLoggedIn(loggedIn);

                userlist.add(currentUser);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userlist;
    }

    public List<User> getAllLoggedOutUsers() throws SQLException {
        List<User> userlist = new ArrayList<User>();

        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String usrname;
        String firstname;
        String lastname;
        String password;
        String lastTimeLoggedIn;
        boolean loggedIn;

        User currentUser = new User();
        currentUser.setUsername("0");
        currentUser.setFirstname("0");
        currentUser.setLastname("0");
        currentUser.setPassword("0");
        currentUser.setLastTimeLoggedIn("1970-01-01");
        currentUser.setLoggedIn(false);

        ResultSet res;
        Statement stm = mysqlconn.getConn().createStatement();
        res= stm.executeQuery("Select * from users where loggedIn = false");

        try{
            while (res.next()){
                usrname = res.getString(2);
                firstname = res.getString(3);
                lastname = res.getString(4);
                password = res.getString(5);
                lastTimeLoggedIn = res.getString(6);
                loggedIn = res.getBoolean(7);

                currentUser.setUsername(usrname);
                currentUser.setFirstname(firstname);
                currentUser.setLastname(lastname);
                currentUser.setPassword(password);
                currentUser.setLastTimeLoggedIn(lastTimeLoggedIn);
                currentUser.setLoggedIn(loggedIn);

                userlist.add(currentUser);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userlist;
    }

    public Boolean isUserloggedIn(User user) throws SQLException {
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();

        String currentUsername = user.getUsername();
        Boolean currentUserStatus = null;

        ResultSet res;
        Statement stm = mysqlconn.getConn().createStatement();
        res=stm.executeQuery("SELECT loggedIn from users WHERE username ="+currentUsername);
        try{
            while (res.next()){
                currentUserStatus = res.getBoolean(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentUserStatus;
    }
}
