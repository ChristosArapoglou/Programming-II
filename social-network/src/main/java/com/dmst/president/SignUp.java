package com.dmst.president;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {
    /*declaration of variables*/
	String sn;
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String dob;
    String stDept;
    Scanner in = new Scanner(System.in);
    /*asks from the user to give his student number*/   
    String askSn() {
        System.out.println("Please, enter your student number");
        return sn = in.nextLine();
    }
    /*asks from the user to give his first name*/
    String askFirstName() {
        System.out.println("Please, enter your first name.");
        return firstName = in.nextLine();
    }
    /*asks from the user to give his last name*/
    String askLastName() {
        System.out.println("Please, enter your last name.");
        return lastName = in.nextLine();
    }
    /*asks from the user to give his user name that he will use in the platform*/
    String  askUsername() {
        System.out.println("Please, enter your username.");
        return username = in.nextLine();
    }
    /*asks from the user to create password for his user name*/ 
    String  askPassword() {
        System.out.println("Please, create your password.");
        return password = in.nextLine();
    }
    /*asks from the user to give his study department*/
    String askStDept() {
       System.out.println("Please, enter your study department.");
       return stDept = in.nextLine();
    }
    /*asks from the user to give his date of birth*/
     String askDob() {
        System.out.print("Please, enter your date of birth: ");
        System.out.println("Year: ");
        int year = in.nextInt();
        System.out.println("Month: ");
        int month = in.nextInt();
        System.out.println("Day: ");
        int day = in.nextInt();    
        dob = year + "-" + month + "-" + day;
		return dob;
    }
    /*asks from the user to give his email and verifies if the email address is unique*/
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
    static boolean uniqueEmail(final Connection dbcon, final String email) {
        //A method designed to ensure every email is unique in the database.
        boolean flag = false;
        Statement stmt;
		//Searching for the email in the database.
		try {
            //SQL Select Query structure.
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
    /*saves the user's data to the database */
    void newUser(Connection dbcon) {
        DatabaseUser.insertQuery(dbcon, askSn(), askFirstName(), askLastName(), askUsername(), askPassword(), askStDept(), askDob(), askEmail(dbcon));
    }
}
