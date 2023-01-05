package com.dmst.president;

import java.sql.Connection;
import java.util.Scanner;


public class UniPost {
   
    public static void main( String[] args ) {
       /*  Post p = new Post("Alexis Mardas");  // TODO(SQL): username from sql
        p.displayFullPost();
        System.out.println("End"); */
        Connection dbcon = Database.initiateConnection();
        DatabasePost.displayAllPosts(dbcon);
        Scanner in = new Scanner(System.in);
        System.out.println("Press <C> to create a new Post");
        String ans = in.nextLine();
        if (ans.toLowerCase().equals("c")) {
            Post.clearConsole();
            System.out.println("Enter your thoughts :");
            String text = in.nextLine();
            DatabasePost.createPost(dbcon, "8210029", text);
            System.out.println("Post created succesfully");
        }
    }
}

