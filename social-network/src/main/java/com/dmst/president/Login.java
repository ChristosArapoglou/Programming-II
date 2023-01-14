package com.dmst.president;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class is used to request from users to enter their credentials
 * in order to log in the app. If their input is matched with the saved 
 * in the database credentials, they are connected. If their input is
 * incorrect, the process is repetead until users successfully log in or
 * exit the app.
 */
public class Login {
    /**
     * User's Student Number. Used for logging in.
     */
    private String sn;
    /**
     * User's password. Used for logging in.
     */
    private String password;
    private Scanner in = new Scanner(System.in);
    /**
	 * This method is used to check whether the active user has already liked the post he just saw.
	 * If so, he is prevented from re-liking the post. A binary (boolean) value stored in the
	 * database is used to save the user's action on the post.
 	 */
    String askSN() {
        System.out.println("Please, give your University's Student Number.");
        sn = in.nextLine();
        return sn;
    }
    String askPassword() {
        System.out.println("Please, give your password");
        password = in.nextLine();
        return password;
    }
    /** The method verify() verifies user's credentials
    *via User class and prints messages
    about the results of verification */
    void verify(final Connection dbcon) {
    	boolean flag = true;
    	Statement stmt;
    	String sn;
    	String password;
        while (flag) {
        	sn = askSN();
        	password = askPassword();
        	try {
    			stmt = dbcon.createStatement();
                //The query executed is fixed
    			String query = "SELECT password "
    				  + "FROM JUsers "
                      + "WHERE AM = '" + sn + "'";
    			//SQL Select Query structure.
    			ResultSet rs = stmt.executeQuery(query);
    			if (rs.next()) {
    				if (rs.getString("password").equals(password)) {
    					System.out.println("Correct credentials. Welcome online.");
    					flag = false;
                        /* After a successful login, notify the databaase
                         * that the user is now active.
                         */
                        String upQuery = "UPDATE JUsers "
                            +" SET isON = 1" 
                            + "WHERE AM = '" + sn + "'";
                        stmt.executeUpdate(upQuery);
    				} else {
                        System.out.println("Sorry, your credentials are incorrect!");
                        System.out.println();
                        System.out.println("Please, try again!");
                        System.out.println();
                    }   
    			} else {
                    System.out.println("Sorry, your credentials are incorrect!");
                    System.out.println();
                    System.out.println("Please, try again!");
                    System.out.println();
                }   
    		} catch (SQLException e) {
    			System.out.print("An unwanted error occurred. Please "
    					+ "check your credentials again before retrying.");
    		}
        }
    }
}
