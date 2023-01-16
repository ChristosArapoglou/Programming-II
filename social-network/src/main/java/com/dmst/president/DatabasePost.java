package com.dmst.president;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used to perform actions between saved posts and the database.
 * It's used to print posts on the screen, increase total likes, as well as
 * informing the DB for individual users' actions on posts (seen, likes).
 * In order for our Java app to communicate with the database, SQL Queries are
 * used through String variables.
 */
public final class DatabasePost {
    /**
     * This is a utility class and therefore, it is not
     * supposed to have a constructor.
     */
    private DatabasePost() {
    }

    /**
     * This method is designed to display all posts saved on the DB to user's screen.
     * Queries written in SQL are used in order to fetch data from the DB.
     */
    protected static void displayAllPosts(final Connection dbcon) {
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "SELECT username, text, number, "
                  + " dateOfCreation, likes "
                  + " FROM JPost, JUsers "
                  + " WHERE AM = userAM "
                  + " ORDER BY dateOfCreation desc";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Post.displayPost(rs.getString("text"), rs.getString("username"),
                rs.getString("dateOfCreation"), rs.getInt("likes"));
                markPostAsSeen(dbcon, DatabaseUser.getActiveUser(dbcon),
                rs.getInt("number"));
                System.out.println();
                Post.react(dbcon, DatabaseUser.getActiveUser(dbcon), rs.getInt("number"));
                UniPost.clearConsole();
            }
            rs.close();
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * This method is used to increment a post's like counter and save
     * the change in the database. Queries written in SQL are used in order
     * to increase a post's like counter within the DB.
     */
    protected static void incrementLikes(final Connection dbcon, final int postNumber) {
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "UPDATE JPost "
                + " SET likes = likes + 1 "
                + " WHERE number = " + postNumber;
            stmt.executeUpdate(query);
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * This method is used to create a new post and save it in the database. Every post is
     * described by its creator, text (thoughts written), date of creation and its likes.
     * Queries written in SQL are used to save the post in the DB.
     */
    protected static void createPost(final Connection dbcon,
        final String creatorSN, final String text) {
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "INSERT INTO JPost (userAM,text,dateOfCreation,likes) "
            + " VALUES('" + creatorSN + "','" + text + "', GETDATE(), 0);";
            stmt.execute(query);
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * This method is used to notify the database that a user has seen a post.
     * Queries written in SQL are used to determine whether a user has seen
     * a post or not. If he has, the database is informed that the post is seen by that
     * user, but not yet liked.
     */
    protected static void markPostAsSeen(final Connection dbcon,
    final String sn, final int postNumber) {
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "SELECT * "
                + " FROM JSees "
                + " WHERE userAM = " + sn + " AND postNumber = " + postNumber;
            final ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                final String insertQuery = "INSERT INTO JSees (userAM, postNumber,"
                + " hasLiked) VALUES('" + sn + "', '" + postNumber + "', 0)";
                stmt.executeUpdate(insertQuery);
            }
            rs.close();
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * This method is used to notify the database that a user has liked a post.
     * Queries written in SQL update the database that this user has liked
     * a certain post. This action will prevent the user from re-liking the same post
     * after logging in the platform again.
     */
    protected static void markPostAsLiked(final Connection dbcon,
    final String sn, final int postNumber) {
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "UPDATE JSees "
                + " SET hasLiked = 1 "
                + " WHERE userAM = " + sn + " AND postNumber = " + postNumber;
            stmt.executeUpdate(query);
            stmt.close();
        } catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    /**
     * This method is used to check whether the active user has already liked
     * the post he just saw. If so, he is prevented from re-liking the post.
     * A binary (boolean) value stored in the database is used to
     * save the user's action on the post.
     */
    protected static boolean ensureUniqueLikes(final Connection dbcon,
    final String sn, final int postNumber) {
        boolean flag = false;
        Statement stmt;
        try {
            stmt = dbcon.createStatement();
            final String query = "SELECT hasLiked "
                + "FROM JSees "
                + "WHERE userAM = " + sn + " AND postNumber = " + postNumber;
            final ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                final int bin = rs.getInt("hasLiked");
                if (bin == 1) {
                    flag = true;
                }
            }
            rs.close();
            stmt.close();
        }  catch (final SQLException e) {
            System.out.print("SQLException: ");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }
}
