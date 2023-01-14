package com.dmst.president;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class asks the user to input their personal data in order
 * to sign up to our social media platform. After verifying that 
 * their Student Number and email are unique (there aren't duplicates
 * in the database), their sign up is completed and is registered to
 * our database. 
 */
public class SignUp {
    /**
     * User's Student Number.
     */
	String sn;
    /**
     * User's first name.
     */
    String firstName;
    /**
     * User's last name.
     */
    String lastName;
    /**
     * User's username.
     */
    String username;
    /**
     * User's password.
     */
    String password;
    /**
     * User's email.
     */
    String email;
    /**
     * User's date of birth.
     */
    String dob;
    /**
     * User's AUEB study department.
     */
    String stDept;
    Scanner in = new Scanner(System.in);
    /**
     * This method asks the user for their Student Number.
     */
    String askSn() {
        System.out.println("Please, enter your student number.");
        return sn = in.nextLine();
    }
    /**
     * This method asks the user for their first name.
     */
    String askFirstName() {
        System.out.println("Enter your first name.");
        return firstName = in.nextLine();
    }
    /**
     * This method asks the user for their last name.
     */
    String askLastName() {
        System.out.println("Enter your last name.");
        return lastName = in.nextLine();
    }
    /**
     * This method asks the user for their username.
     */
    String  askUsername() {
        System.out.println("Enter your username.");
        return username = in.nextLine();
    }
    /**
     * This method asks the user for their password.
     */ 
    String  askPassword() {
        System.out.println("Create your password.");
        return password = in.nextLine();
    }
    /**
     * This method asks the user for their study department.
     */
    String askStDept() {
       System.out.println("Enter your study department.");
       return stDept = in.nextLine();
    }
    /**
     * This method asks the user for their date of birth.
     */
     String askDob() {
        System.out.println("Enter your date of birth: ");
        System.out.println("Year: ");
        int year = in.nextInt();
        System.out.println("Month: ");
        int month = in.nextInt();
        System.out.println("Day: ");
        int day = in.nextInt();    
        dob = year + "-" + month + "-" + day;
		return dob;
    }
    /**
     * This method asks the user for their email. A verification check
     * is executed in this method to ensure that the user's email is not
     * already registered in the database.
     */
    String askEmail(Connection dbcon) {
        System.out.println("Please, enter your email address.");
        do {
            email = in.nextLine();
            email = in.nextLine();
        } while (uniqueEmail(dbcon, email));
        System.out.println("Accepted email address.");
        UniPost.delay(1000);
 		return email;
    }
    /**
     * This method takes the user's email as a parameter and checks
     * whether this email exists in the database or not. If it doesn't,
     * the user can proceed with the sign up process. If it exists, it 
     * means that some other user uses this email, so he has to enter a 
     * different, unique email address to continue.
     */
    static boolean uniqueEmail(final Connection dbcon, final String email) {
        boolean flag = false;
        Statement stmt;
		try {
            stmt = dbcon.createStatement();
			String query = "SELECT * FROM JUsers WHERE email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(query);	
		 	if (rs.next()) {
                System.err.println("This email already exists. "
                    + "Please insert a new email address.");
                flag = true;
            }
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        return flag;
    }
    /**
     * This method takes all of the user's input data and stores it in the 
     * database as a new user.
     */
    void newUser(Connection dbcon) {
        DatabaseUser.insertUser(dbcon, askSn(), askFirstName(), askLastName(), askUsername(), askPassword(), askStDept(), askDob(), askEmail(dbcon));
    }
}
