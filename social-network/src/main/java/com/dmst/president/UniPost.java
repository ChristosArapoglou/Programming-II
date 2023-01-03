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
           // likes++;
           /* Since we are using a database to store data
            * we don't have to increment the instance variable likes
            * instead we should update table JPosts directly.
            * If we try to increment the instance variable likes a problem 
            * occurs, because this method is static.As a matter of fact 
            * almost all of this class' methods should be static
            * since we don't want to create a new post in order to access them.
           */
        	Login l = new Login();
            l.verify(dbcon);
            delay(2500);
        }
        in.close();
    }
    public static void delay(final long delayDuration) {
        try {
            Thread.sleep(delayDuration);
        } catch (InterruptedException e) {
            System.err.println("The operation was interrupted");
        }
    }
}