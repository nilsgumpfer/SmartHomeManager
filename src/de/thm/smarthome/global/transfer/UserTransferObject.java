package de.thm.smarthome.global.transfer;

import de.thm.smarthome.global.beans.UserGroupBean;
import de.thm.smarthome.global.enumeration.EMessageCode;

/**
 * Created by Nils on 05.02.2017.
 */
public class UserTransferObject {
    private EMessageCode responseCode;
    private String message;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String eMail;
    private UserGroupBean userGroup;

    public UserTransferObject(String username, String password, String firstname, String lastname, String eMail, UserGroupBean userGroup) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.eMail = eMail;
        this.userGroup = userGroup;
    }

    public UserTransferObject(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public EMessageCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(EMessageCode responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public UserGroupBean getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupBean userGroup) {
        this.userGroup = userGroup;
    }
}
