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
			 	Post.displayPost(rs.getString("text"), rs.getString("username")
                    , rs.getString("dateOfCreation"), rs.getInt("likes"));
				markPostAsSeen(dbcon, DatabaseUser.getActiveUser(dbcon) , rs.getInt("number"));
				System.out.println();
				Post.react(dbcon, DatabaseUser.getActiveUser(dbcon), rs.getInt("number"));
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
			String query = "UPDATE JPost "
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


	static void markPostAsSeen(Connection dbcon, String AM, int postNumber) {
		/* This method is used to notify the database that a user
		 * has seen a post.
		 */
		Statement stmt;
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT * "
			    +"FROM JSees "
				+"WHERE userAM = "+AM+" AND postNumber = "+postNumber;
			ResultSet rs = stmt.executeQuery(query);
			/*  if the user hasn't already seen the post and
			 * therefore the result set is empty.
			 */
			if (!rs.next()) {
				String insertQuery = "INSERT INTO JSees (userAM,postNumber,hasLiked) "
				    +"VALUES('"+AM+"','"+postNumber+"',0)";
				/* Notify the database that a user just saw a post
				 * he has yet to like.
				 */
				stmt.executeUpdate(insertQuery);
			}			
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	static void markPostAsLiked(Connection dbcon, String AM, int postNumber) {
		/* This method is used to notify the database that a user
		 * has liked a post.
		 */
		Statement stmt;
		try {
			stmt = dbcon.createStatement();
			String query = "UPDATE JSees "
			    +"SET hasLiked = 1 "
				+"WHERE userAM = "+AM+" AND postNumber = "+postNumber;
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	static boolean ensureUniqueLikes(Connection dbcon, String AM, int postNumber) {
		/* This method is used to check whether or not the active user
		 * has already liked the post he just saw.
		 */
		// We assume that he hasn't already liked the post.
		boolean flag = false;
		Statement stmt;
		try {
			stmt = dbcon.createStatement();
			String query = "SELECT hasLiked "
			    +"FROM JSees "
				+"WHERE userAM = "+AM+" AND postNumber = "+postNumber;
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int bin = rs.getInt("hasLiked");
				// hasLiked is binary in the database
				if (bin == 1) {
                    flag = true;
				}
			}
		}  catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
        return flag;
	}
}
