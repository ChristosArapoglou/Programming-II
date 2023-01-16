package com.dmst.president;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String sn;
    private final Date dob;
    private String stDept;
    private Date signUpDate;
    /**
     * @return the firstName
     */
    protected String getFirstName() {
        return firstName;
    }
    /**
     * @return the lastName
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
     * @return the sn
     */
    protected String getSn() {
        return sn;
    }
    /**
     * @return the dob
     */
    protected Date getDob() {
        return dob;
    }
    /**
     * @return the stDept
     */
    protected String getStDept() {
        return stDept;
    }
    /**
     * @return the signUpDate
     */
    protected Date getSignUpDate() {
        return signUpDate;
    }
    /**
     * @param firstName the firstName to set
     */
    protected void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @param lastName the lastName to set
     */
    protected void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @param username the username to set
     */
    protected void setUsername(final String username) {
        this.username = username;
    }
    /**
     * @param password the password to set
     */
    protected void setPassword(final String password) {
        this.password = password;
    }
    /**
     * @param email the email to set
     */
    protected void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @param sn the sn to set
     */
    protected void setSn(final String sn) {
        this.sn = sn;
    }
    /**
     * @param stDept the stDept to set
     */
    protected void setStDept(final String stDept) {
        this.stDept = stDept;
    }
    /**
     * @param signUpDate the signUpDate to set
     */
    protected void setSignUpDate(final Date signUpDate) {
        this.signUpDate = signUpDate;
    }
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
        this.signUpDate = new Date();
    }
}
