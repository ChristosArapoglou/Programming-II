package com.dmst.president;

import java.sql.Connection;
import java.util.Scanner;

public class UniPost {
	final static String WELCOME = "Welcome to UniPost, the first application designed "
			+ "for University students, by University students. Using this app, you can "
			+ "discuss issues concerning your University and try finding excellent "
			+ "solutions with the other users.";
    static Scanner in = new Scanner(System.in);
    public static void main( String[] args ) {
        Connection dbcon = Database.initiateConnection();
        welcomeUser();
        displayLoginSignupPage(dbcon);
        displayWall(dbcon);
    }
    public static void delay(final long delayDuration) {
        try {
            Thread.sleep(delayDuration);
        } catch (InterruptedException e) {
            System.err.println("The operation was interrupted.");
        }
    }
    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void welcomeUser() {
         //Prints welcome message
         clearConsole();
         System.out.println(WELCOME);
         System.out.println();    
    }
    public static void displayLoginSignupPage(Connection dbcon) {
        String ans;
        
        boolean flag = false;
        do {
            System.out.println("Press <S> to sign up to our app "
            		+ "<L> to log in if you are already registered.");
            ans = in.nextLine();
            /* the answer is converted to lower case,
                * then checked if it meets the criteria */
            if (!(ans.toLowerCase().equals("s") || ans.toLowerCase().equals("l"))) {
                    System.out.println("Wrong answer");
                    delay(500);
                    clearConsole();
                    flag = true;
            }
        } while (flag);
        if (ans.toLowerCase().equals("l")) {
        	Login l = new Login();
            l.verify(dbcon);
            delay(2500);
        } else {
        	SignUp s = new SignUp();
        	s.newUser(dbcon);
        	try {
        		System.out.println("Your sign up has been successfully completed."
                    +"\nYou will now return to the login screen.");
            	Thread.sleep(4000);
                clearConsole();
                displayLoginSignupPage(dbcon);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void displayWall(Connection dbcon) {
        boolean flag = false;
        do {
            System.out.println("Press <C> to create a new Post");
            System.out.println("Press <V> to view the latest Posts");
            System.out.println("Press <L> to logout and return to main screen");
            System.out.println("Press <E> to exit the programm");
            String ans = in.nextLine();
            
            if (ans.toLowerCase().equals("c")) {
                flag = true;
                clearConsole();
                System.out.println("Enter your thoughts :");
                String text = in.nextLine();
                DatabasePost.createPost(dbcon, DatabaseUser.getActiveUser(dbcon), text);
                System.out.println("Post created succesfully");
            } else if (ans.toLowerCase().equals("v")) {
                clearConsole();
                DatabasePost.displayAllPosts(dbcon);
                flag = true;
            } else if (ans.toLowerCase().equals("l")) {
                DatabaseUser.logOutUser(dbcon, DatabaseUser.getActiveUser(dbcon));
                clearConsole();
                flag = true;
                displayLoginSignupPage(dbcon);
            } else if (ans.toLowerCase().equals("e")) {
                DatabaseUser.logOutUser(dbcon, DatabaseUser.getActiveUser(dbcon));
                System.exit(1);
            } else {
                System.out.println("Wrong input!!");
                delay(750);
                clearConsole();
            }
        } while (flag); 
    }
}
