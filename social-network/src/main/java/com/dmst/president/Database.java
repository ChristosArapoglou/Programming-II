package com.dmst.president;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database {
    static Connection initiateConnection() {
        // Initiating a connection with our MS SQL Server database.
        String url = "jdbc:sqlserver://CHRIS\\MSSQLSERVER01;"
        + "databaseName=DB48;"
        + "user=G548;password=9398v4;trustServerCertificate=true";
        Connection dbcon = null;
		/* Handling possible unwanted exceptions,
		in case the connection cannot occur. */
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