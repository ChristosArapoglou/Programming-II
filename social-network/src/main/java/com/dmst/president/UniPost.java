package com.dmst.president;

import java.sql.Connection;


public class UniPost {
   
    public static void main( String[] args ) {
       /*  Post p = new Post("Alexis Mardas");  // TODO(SQL): username from sql
        p.displayFullPost();
        System.out.println("End"); */
        Connection dbcon = Database.initiateConnection();
        DatabasePost.displayAllPosts(dbcon);
        
        }
    }

