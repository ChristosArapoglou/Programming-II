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
	static void insertUser(final Connection dbcon, final String sn,
        final String firstName, final String lastName, final String username,
        final String password, final String stDept, final String dob, final String email) {
		/* Initiating a SQL Insert statement (inserting new data
		   in the database).*/
		Statement stmt;
		/* This boolean variable informs whether 
		the query was successfully executed or not. */
		boolean flag = false;
		try {
			stmt = dbcon.createStatement();
			//SQL Insert Query structure.
			String query = "INSERT INTO JUsers VALUES('" + sn
			+ "', '" + firstName + "', '" + lastName + "', '"
		    + username + "', '" + password + "', '" + stDept
		    + "', '" + dob + "', '" + email + "', 0)";
			/* The "execute" method is used to insert the data
		 	in the database */
			stmt.execute(query);
			// If no exceptions are created, the value of flag turns true.
			flag = true;
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		/* Checking whether the data insertion was successful or not,
		based on the "execute" method return statement. */
		if (flag) {
			System.out.println("Successful data insertion.");
		} else {
			System.out.println("Unsuccessful data insertion.");
		}
	}
	static String getActiveUser(final Connection dbcon) {
		/* This method finds the user set active
		 * by a successful login. 
		 */
		Statement stmt; 
		String activeUser = null;
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT AM "
			    +"FROM JUsers "
				+"WHERE isON = 1";
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
	static void logOutUser(Connection dbcon, String sn) {
		/* This method is used to notify the database that the user
		 * is no longer active.
		 */
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