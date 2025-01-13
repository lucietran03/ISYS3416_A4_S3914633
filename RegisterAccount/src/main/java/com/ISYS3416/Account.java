package com.ISYS3416;

import java.util.Date;

/**
 * The {@code Account} class represents a user's account with attributes such as full name,
 * date of birth, email, username, and password. It provides constructors for creating account
 * instances, along with getter and setter methods to access and modify the account details.
 *
 * This class can be used in systems requiring user account management.
 *
 * @author Tran Dong Nghi - S3914633
 * @version 1.0
 */
public class Account {
    /**
     * Full name of the account holder.
     */
    private String fullName;

    /**
     * Date of birth of the account holder.
     */
    private Date dateOfBirth;

    /**
     * Email address of the account holder.
     */
    private String email;

    /**
     * Username of the account holder.
     */
    private String username;

    /**
     * Password of the account holder. This should be stored securely in real-world applications.
     */
    private String password;

    /**
     * Constructs an {@code Account} object with the specified details.
     *
     * @param fullName    the full name of the account holder
     * @param dateOfBirth the date of birth of the account holder
     * @param email       the email address of the account holder
     * @param username    the username of the account holder
     * @param password    the password of the account holder
     */
    public Account(String fullName, Date dateOfBirth, String email, String username, String password) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Default constructor for creating an {@code Account} object with no initial details.
     */
    public Account() {}

    /**
     * Retrieves the full name of the account holder.
     *
     * @return the full name of the account holder
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the account holder.
     *
     * @param fullName the full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieves the date of birth of the account holder.
     *
     * @return the date of birth of the account holder
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the account holder.
     *
     * @param dateOfBirth the date of birth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the email address of the account holder.
     *
     * @return the email address of the account holder
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the account holder.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the username of the account holder.
     *
     * @return the username of the account holder
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the account holder.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the account holder.
     *
     * @return the password of the account holder
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the account holder. In real-world applications, ensure this
     * is securely handled.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}