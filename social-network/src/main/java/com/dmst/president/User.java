package com.dmst.president;

//import java.text.SimpleDateFormat;  
import java.util.Date;

class User {
	private String firstName; 
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String sn;
	private Date dob;
	private String stDept;
	private Date signUpDate;
	/**
	 * @return the firstName
	 */
	String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	String getLastName() {
		return lastName;
	}
	/**
	 * @return the username
	 */
	String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	String getPassword() {
		return password;
	}
	/**
	 * @return the email
	 */
	String getEmail() {
		return email;
	}
	/**
	 * @return the sn
	 */
	String getSn() {
		return sn;
	}
	/**
	 * @return the dob
	 */
	Date getDob() {
		return dob;
	}
	/**
	 * @return the stDept
	 */
	String getStDept() {
		return stDept;
	}
	/**
	 * @return the signUpDate
	 */
	Date getSignUpDate() {
		return signUpDate;
	}
	/**
	 * @param firstName the firstName to set
	 */
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param username the username to set
	 */
	void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param email the email to set
	 */
	void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param sn the sn to set
	 */
	void setSn(String sn) {
		this.sn = sn;
	}
	/**
	 * @param stDept the stDept to set
	 */
	void setStDept(String stDept) {
		this.stDept = stDept;
	}
	/**
	 * @param signUpDate the signUpDate to set
	 */
	void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}
	User(String firstName, String lastName, String username, String password, 
			String email, String sn, Date dob, String stDept) {
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
	User() {
	}
}