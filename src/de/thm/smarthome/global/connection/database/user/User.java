package de.thm.smarthome.global.connection.database.user;

import de.thm.smarthome.main.device.heating.adapter.BuderusHeatingAdapter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Nils on 28.01.2017.
 */
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String role;
    public User(String firstname, String lastname, String username, String password, String role)
    {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password= password;
        this.role = role;
    }
    private boolean loggedIn;
    private String lastTimeLoggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User( )
    {
        super();
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

    public String getUsername() { return username; }

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

    public Integer getId(){
        return this.Id;
    }
}
