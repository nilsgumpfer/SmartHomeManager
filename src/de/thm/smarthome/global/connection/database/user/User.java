package de.thm.smarthome.global.connection.database.user;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Nils on 28.01.2017.
 */
public class User {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String role;
    private boolean loggedIn;
    private String lastTimeLoggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastTimeLoggedIn(){
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(String date){
        //Date currentTimestamp = new Date(Calendar.getInstance().getTime().getTime());
        this.lastTimeLoggedIn = date;
    }
}
