import java.sql.*;

public class Verify {

    static boolean uniqueEmail(final Connection dbcon, final String email) {
        //A method designed to ensure every email is unique in the database.
        boolean flag = false;
        Statement stmt;
		//Searching for the email in the database.
		try {
            //SQL Select Query structure.
            stmt = dbcon.createStatement();
			String query = "SELECT * FROM JUsers WHERE" + " email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(query);
			
		 	if (rs.next()) {
                System.err.println("This email already exists!"
                    + " Please insert a new email address.");
                flag = true;
            } else {
                flag = false;
            } 
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
        }
        return flag;
    }
    static boolean login(final Connection dbcon, final String username,
        final String password) {
        //Verify user's credentials and allow him to log in the app.
        boolean flag = false;
        Statement stmt;
        //Searching for the user in the database, based on the credentials given.
        try {
            //SQL Select Query structure.
            stmt = dbcon.createStatement();
            String query = "SELECT * FROM JUsers WHERE" + " username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(query);
            //Checking if the user exists in the database.
            if (rs.next()) {
                System.err.println("Valid credentials. Welcome in UniPost!");
                flag = false;
            } else {
                System.err.println("Invalid credentials. Insert your username and password carefully.");
                flag = true;
            }
        } catch (SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }
}