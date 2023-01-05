package com.dmst.president;

import java.sql.Connection;
import java.util.Scanner;


public class UniPost {
	final static String WELCOME = "Welcome to UniPost, the first application designed "
			+ "for University students, by University students. Using this app, you can "
			+ "discuss issues concerning your University and try finding excellent "
			+ "solutions with the other users.";
    public static void main( String[] args ) {
        Connection dbcon = Database.initiateConnection();
        System.out.println(WELCOME);
        String ans;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Press <S> to sign up to our app "
            		+ "<L> to log in if you are already registered.");
            ans = in.nextLine();
            /* the answer is converted to lower case,
                * then checked if it meets the criteria */
            if (!(ans.toLowerCase().equals("s") || ans.toLowerCase().equals("l"))) {
                    System.out.println("Wrong answer");
            }
        } while (!(ans.toLowerCase().equals("s") || (ans.toLowerCase().equals("l"))));
        if (ans.toLowerCase().equals("l")) {
        	Login l = new Login();
            l.verify(dbcon);
            try {
            	Thread.sleep(2500);
            } catch (InterruptedException e) {
            }
        } else {
        	SignUp s = new SignUp();
        	s.newUser(dbcon);
        	try {
        		System.out.println("Your sign up has been successfully completed. Welcome online.");
            	Thread.sleep(2500);
            } catch (InterruptedException e) {
            }
        }
        DatabasePost.displayAllPosts(dbcon);
        System.out.println("Press <C> to create a new Post");
        ans = in.nextLine();
        if (ans.toLowerCase().equals("c")) {
            Post.clearConsole();
            System.out.println("Enter your thoughts :");
            String text = in.nextLine();
            DatabasePost.createPost(dbcon, "8210029", text);
            System.out.println("Post created succesfully");
        }
    }
}