package com.dmst.president;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

class DatabaseUser {
	static void selectQuery(final Connection dbcon,
			final String columnName1, final String columnName2) {
		/* Initiating a SQL Select statement (searching for data
		in the database and displaying them to the user). */
		Statement stmt;
		//Creating a SQL Select Query, handling unwanted exceptions.
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT " + columnName1
					+ ", " + columnName2 + " FROM Users";
			//SQL Select Query structure.
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			//Displaying the SQL Query results.
		 	while (rs.next()) {
		 		System.out.print(rs.getString(columnName1) + " - ");
		 		System.out.println(rs.getString(columnName2));
		 	}
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	static void insertQuery(final Connection dbcon, final String sn,
        final String firstName, final String lastName, final String username,
        final String password, final String stDept, final GregorianCalendar dob, final String email) {
		/* Initiating a SQL Insert statement (inserting new data
		   in the database).*/
		Statement stmt;
		/* This boolean variable informs whether 
		the query was successfully executed or not. */
		boolean flag = false;
		try {
			stmt = dbcon.createStatement();
			//SQL Insert Query structure.
			String query = "INSERT INTO Users VALUES('" + sn
			+ "', '" + firstName + "', '" + lastName + "', '"
		    + username + "', '" + password + "', '" + stDept
		    + "', '" + dob + "', '" + email + "')";
			/* The "execute" method is used to insert the data
		 	in the database */
			stmt.execute(query);
			// If no exceptions are created, the value of flag turns true.
			flag = true;
			System.out.println(query);
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		/* Checking whether the data insertion was successful or not,
		based on the "execute" method return statement. */
		if (flag) {
			System.out.println("Successful data insertion! :)");
		} else {
			System.out.println("Unsuccessful data insertion... :(");
		}
	}
}

