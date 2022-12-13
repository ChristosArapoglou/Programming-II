import java.sql.*;

public class DatabasePost {
	static void selectPost(final Connection dbcon,
		final String columnName1, final String columnName2) {
		/* Initiating a SQL Select statement (searching for data
		in the database and displaying them to the user). */
		Statement stmt;
		//Creating a SQL Select Query, handling unwanted exceptions.
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT " + columnName1
				+ ", " + columnName2 + " FROM JPost";
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
	static void createPost(final Connection dbcon, final int number,
	    final String creatorSN, final String text) {
		/* Initiating a SQL Insert statement (inserting a new post
	 	in the database).*/
		Statement stmt;
		boolean flag = false;
		try {
			stmt = dbcon.createStatement();
			//SQL Insert Query structure.
			String query = "INSERT INTO JPost VALUES(" + number
				+ ", '" + creatorSN + "', '" + text + "', GETDATE(), 0";
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
			System.out.println("Successful post insertion! :)");
		} else {
			System.out.println("Unsuccessful post insertion... :(");
		}
	}
}

