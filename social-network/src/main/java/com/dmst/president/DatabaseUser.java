package com.dmst.president;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used to perform actions between saved users and the database.
 * It's used to print users' data on the screen, store new users in the DB, 
 * informing other classes about the current active user and ensure
 * users log out of the app smoothly.
 * In order for our Java app to communicate with the database, SQL Queries are 
 * used through String variables.
 */
class DatabaseUser {
	/**
	 * This method is used to insert a new user and save them in the database. 
	 * Every user is described by their Student Number, first name, last name,
	 * username, password, study department at AUEB, date of birth and email.
	 * Queries written in SQL are used to store users in the DB.
 	 */
	static void insertUser(final Connection dbcon, final String sn,
        final String firstName, final String lastName, final String username,
        final String password, final String stDept, final String dob, final String email) {
		Statement stmt;
		boolean flag = false;
		try {
			stmt = dbcon.createStatement();
			String query = "INSERT INTO JUsers VALUES('" + sn
			+ "', '" + firstName + "', '" + lastName + "', '"
		    + username + "', '" + password + "', '" + stDept
		    + "', '" + dob + "', '" + email + "', 0)";
			stmt.execute(query);
			flag = true;
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		if (flag) {
			System.out.println("Successful data insertion.");
		} else {
			System.out.println("Unsuccessful data insertion.");
		}
	}
	/**
	 * This method recognizes which user is currently active and returns
	 * their Student Number.
	 * Queries written in SQL are used to inform the Java program whether
	 * a user is active or not.
 	 */
	static String getActiveUser(final Connection dbcon) {
		Statement stmt; 
		String activeUser = null;
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT AM "
			    + " FROM JUsers "
				+ " WHERE isON = 1";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				activeUser = rs.getString("AM");
			}
			return activeUser;
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return activeUser;
	}
	/**
	 * This method is used to update the database that the user is
	 * no longer active after logging out.
	 * Queries written in SQL are used to update the database about
	 * the change in user's status.
 	 */
	static void logOutUser(Connection dbcon, String sn) {
		Statement stmt;
		try {
			stmt = dbcon.createStatement();
			String query = "UPDATE JUsers "
			    +" SET isON = 0" 
			    + "WHERE AM = '" + sn + "'";
			stmt.executeUpdate(query);			
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}