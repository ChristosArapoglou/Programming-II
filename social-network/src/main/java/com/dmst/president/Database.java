package com.dmst.president;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to initiate a connection with our database.
 * Our database is located in AUEB's Microsoft SQL Server. 
 */
public class Database {
	/**
 	* This method, given the server's url and our DB's correct
 	* credentials, connects our app with the DB. 
 	*/
    public static Connection initiateConnection() {
        String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr;"
        + "databaseName=DB48;"
        + "user=G548;password=9398v4;";
        Connection dbcon = null;
		try {
			Class.forName(
		    "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		return dbcon;
	}
}
