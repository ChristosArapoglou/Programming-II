package com.dmst.president;

import java.sql.Connection;
import java.util.Scanner;

/**
 * This class is used to combine and coordinate all the actions of all
 * the other classes in order to make the application executable. Apart from
 * the main method, it includes other methods that help visualize and display
 * the app's output to the user.
 */
public final class UniPost {
    /**
    * A friendly, welcoming message to the user.
    */
    private static final String WELCOME = "Welcome to UniPost, the first "
     + "application designed for University students, by University students. \r\n "
     + "Using this app, you can discuss issues concerning your University "
     + "and try finding excellent solutions with the other users.";
    private static Scanner in = new Scanner(System.in);

    /**
     * This is a utility class and therefore, it is not
     * supposed to have a constructor.
     */
    private UniPost() {

    }
    /**
     * The main method which is responsible for making the program run
     * and function properly.
     */
    public static void main(final String[] args) {
        final Connection dbcon = Database.initiateConnection();
        welcomeUser();
        displayLoginSignupPage(dbcon);
        displayWall(dbcon);
    }
    /**
     * This method is used to delay some action in order to give time
     * to the user to understand what has happenned so far.
     */
    protected static void delay(final long delayDuration) {
        try {
            Thread.sleep(delayDuration);
        } catch (final InterruptedException e) {
            System.err.println("The operation was interrupted.");
        }
    }
    /**
     * This method clears eveything from the command line window, so
     * as to make the app more visually organised and attractive to the user.
     */
    protected static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method welcomes the user in the application after opening it.
     */
    protected static void welcomeUser() {
         //Prints welcome message
         clearConsole();
         System.out.println(WELCOME);
         System.out.println();
    }
    /**
     * This method is organising the login and sign up display
     * in order to make it more efficient for the user to use.
     */
    protected static void displayLoginSignupPage(final Connection dbcon) {
        String ans;
        boolean flag;
        do {
            flag = true;
            System.out.println("Press <S> to sign up to our app or "
                    + "<L> to log in if you are already registered.");
            ans = in.nextLine();
            /* the answer is converted to lower case,
                * then checked if it meets the criteria */
            if (!(ans.toLowerCase().equals("s") || ans.toLowerCase().equals("l"))) {
                    System.out.println("Wrong answer");
                    delay(500);
                    clearConsole();
                    flag = false;
            }
        } while (!flag);
        if (ans.toLowerCase().equals("l")) {
            final Login l = new Login();
            l.verify(dbcon);
            delay(2500);
        } else {
            final SignUp s = new SignUp();
            s.newUser(dbcon);
            try {
                System.out.println("Your sign up has been successfully completed."
                    + "\nYou will now return to the login screen.");
                Thread.sleep(4000);
                clearConsole();
                displayLoginSignupPage(dbcon);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * This method is organising posts display so the user can read
     * and interact properly with them, without being visually unattractive.
     */
    protected static void displayWall(final Connection dbcon) {
        boolean flag = false;
        do {
            System.out.println("Press <C> to create a new Post");
            System.out.println("Press <V> to view the latest Posts");
            System.out.println("Press <L> to logout and return to main screen");
            System.out.println("Press <E> to exit the programm");
            final String ans = in.nextLine();

            if (ans.toLowerCase().equals("c")) {
                flag = true;
                clearConsole();
                System.out.println("Enter your thoughts :");
                final String text = in.nextLine();
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
