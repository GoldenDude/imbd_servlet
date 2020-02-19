package com.azranozeri.usermanagement.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User model implementation
 * Represents Users table in the database.
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * user name
     */
    private String userName;
    /**
     * hashed password
     */
    private String passwordHash;
    /**
     * email
     */
    private String email;

    public User(){}

    /**
     * creates a new user.
     * @param userName - user name
     * @param passwordHash - hashed password
     * @param email - email
     */
    public User(String userName, String passwordHash, String email) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    /* getters and setters */
    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
