package com.dmst.president;

/**
 * This class is used to describe a user and help them
 * interact properly with other classes.
 */
public class User {
    /**
     * User's first name.
     */
    private String firstName;
    /**
     * User's last name.
     */
    private String lastName;
    /**
     * User's username.
     */
    private String username;
    /**
     * User's password.
     */
    private String password;
    /**
     * User's email.
     */
    private String email;
    /**
     * User's Student Number.
     */
    private String sn;
    /**
     * User's date of birth.
     */
    private final Date dob;
    /**
     * User's study department in AUEB.
     */
    private String stDept;
    /**
     * @return the first name
     */
    protected String getFirstName() {
        return firstName;
    }
    /**
     * @return the last name
     */
    protected String getLastName() {
        return lastName;
    }
    /**
     * @return the username
     */
    protected String getUsername() {
        return username;
    }
    /**
     * @return the password
     */
    protected String getPassword() {
        return password;
    }
    /**
     * @return the email
     */
    protected String getEmail() {
        return email;
    }
    /**
     * @return the student number
     */
    protected String getSn() {
        return sn;
    }
    /**
     * @return the date of birth
     */
    protected Date getDob() {
        return dob;
    }
    /**
     * @return the study department
     */
    protected String getStDept() {
        return stDept;
    }
    /**
     * @param firstName the new first name to set
     */
    protected void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @param lastName the new last name to set
     */
    protected void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @param username the new username to set
     */
    protected void setUsername(final String username) {
        this.username = username;
    }
    /**
     * @param password the new password to set
     */
    protected void setPassword(final String password) {
        this.password = password;
    }
    /**
     * @param email the new email to set
     */
    protected void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @param sn the new student to set
     */
    protected void setSn(final String sn) {
        this.sn = sn;
    }
    /**
     * @param stDept the new study department to set
     */
    protected void setStDept(final String stDept) {
        this.stDept = stDept;
    }
    /**
     * This class's constructor.
     */
    protected User(final String firstName, final String lastName,
    final String username, final String password, final String email,
    final String sn, final Date dob, final String stDept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sn = sn;
        this.dob = dob;
        this.stDept = stDept;
    }
}
