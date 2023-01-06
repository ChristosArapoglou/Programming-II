package com.dmst.president;

import java.sql.*;

public class DatabasePost {
	static void displayAllPosts(final Connection dbcon) {
		/* Initiating a SQL Select statement (searching for data
		in the database and displaying them to the user). */
		Statement stmt;
		//Creating a SQL Select Query, handling unwanted exceptions.
		try {
			stmt = dbcon.createStatement();
            //The query executed is fixed
			String query = "SELECT username, text, number,"
                  +"dateOfCreation, likes"
				  + " FROM JPost, JUsers"
                  +" WHERE AM = userAM"
				  + " ORDER BY dateOfCreation desc";
			//SQL Select Query structure.
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
			 	Post.displayFullPost(rs.getString("text"), rs.getString("username")
                    , rs.getString("dateOfCreation"), rs.getInt("likes"));
				Post.react(dbcon, rs.getInt("number"));
				UniPost.clearConsole();

			}
             
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	static void incrementLikes(final Connection dbcon, final int postNumber) {
    /* This method is used to increment a post's like counter
	 * inside the database.
	 */
	    Statement stmt;
		try {
			stmt = dbcon.createStatement();
            // SQL Update query structure
			String query = "UPDATE Jpost "
			    +" SET likes = likes + 1 "
				+" WHERE number = " + postNumber;
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}


	}


	static void createPost(final Connection dbcon,
	    final String creatorSN, final String text) {
		/* Initiating a SQL Insert statement (inserting a new post
	 	in the database).*/
		Statement stmt;
		try {
			stmt = dbcon.createStatement();
			//SQL Insert Query structure.
			String query = "INSERT INTO JPost (userAM,text,dateOfCreation,likes) VALUES('"+ creatorSN + "','" + text + "', GETDATE(), 0);";
			/*The "execute" method returns a boolean value
			which is stored in a boolean variable. */
			stmt.execute(query);
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
