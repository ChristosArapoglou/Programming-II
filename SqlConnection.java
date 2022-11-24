import java.sql.*;

public class SqlConnection {
	
	public static void main(String[] args) {
		String name;
		String url = "jdbc:sqlserver://CHRIS\\MSSQLSERVER01;"+"databaseName=DB_Project;user=user;password=user;trustServerCertificate=true";
		Connection dbcon ;
		Statement stmt;
		ResultSet rs;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		System.out.println("Welcome to our database");
		
  		/* Execute SQL queries */
		try {
			dbcon = DriverManager.getConnection(url);
			stmt = dbcon.createStatement();
  	 		rs = stmt.executeQuery("SELECT name FROM Geo_Location WHERE avg_income >60000");
  	 		while (rs.next()) {
  	 			name=rs.getString("name");
  	 			System.out.println(name);
  	 		}
  	 		rs.close();
  	 		stmt.close();
  	 		dbcon.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
	} 
	
} 

