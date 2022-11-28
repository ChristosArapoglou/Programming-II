import java.sql.*;

class Database {
    static Connection initiateConnection() {
        // Initiating a connection with our MS SQL Server database.
        String url = "jdbc:sqlserver://CHRIS\\MSSQLSERVER01;"
        + "databaseName=Unipost;"
        + "user=user;password=user;trustServerCertificate=true";
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
        final String password, final String stDept, final String dob) {
		/* Initiating a SQL Insert statement (inserting new data
		   in the database).*/
		Statement stmt;
		boolean flag = false;
		try {
			stmt = dbcon.createStatement();
			//SQL Insert Query structure.
			String query = "INSERT INTO Users VALUES('" + sn
			+ "', '" + firstName + "', '" + lastName + "', '"
		    + username + "', '" + password + "', '" + stDept
		    + "', '" + dob + "')";
			/*The "execute" method returns a boolean value
			which is stored in a boolean variable. */
			stmt.execute(query);
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
