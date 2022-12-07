package com.dmst.president;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public final class Post {

    /* This instance variable is necessary only in case we need
     * to keep the date as a date type(for SQL) */
    private Date creationDate;
    private final String strDate;
    private int likes;
    private String text;
    private final String creator; // User's username

    /* Getters are needed to test the program in this particular
     * stage. They might be unnecessary for the final implementation.
     */
    final Scanner in = new Scanner(System.in);


    public void setText(final String text) {
        /* This setter could be used to give users the opportunity
         * to edit their posts. No other instance variable needs
         * a setter to be implemented.
         */
        this.text = text;
    }


    public Post(final String creator) {
        // Current date is allocated on variable creationDate type Date
        final Date creationDate = new Date();
        // The preffered format is implemented
        final DateFormat dateFormat = new SimpleDateFormat(
                                "dd-MM-yyyy hh:mm a");
        // Variable creationDate is converted to String using the format method
        this.strDate = dateFormat.format(creationDate);
        System.out.println("Enter your thoughts :");
        this.text = in.nextLine();
        this.creator = creator;
    }


    public void displayPost() {
        /* This method is used to display a post.If the post
         * exceeds the 70 character limit, then a StringBuffer
         * is used to insert an escape character. */

        final int lineLimit = 70;
        final StringBuffer sb = new StringBuffer(text);
        final int lines = sb.length() / 70;
        for (int i = 1; i <= lines; i++) {
            sb.insert(i * lineLimit, "\n");
        }
        System.out.println(String.format("--------------------------------"
                    + "--------------------------------------\n"
                    + "User %s posted:%40s\n\n%s\n%70s\n"
                    + "--------------------------------------"
                    + "--------------------------------",
                    creator, strDate, sb.toString(), "Likes:" + likes));

    }


    public void displayFullPost() {
        displayPost();
        System.out.println();
        react();
        clearConsole();
        displayPost();

    }

    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.err.println("error");
        }
    }


    public void react() {
        /* This method is used to enable user-post interaction.
         * The user states whether or not he likes the post he
         * just saw. */
        
        String ans;
        do {
            System.out.println("Press <L> to like this post or <N> to move to the next Post");
            ans = in.nextLine();
            /* the answer is converted to lower case,
                * then checked if it meets the criteria */

            if (!(ans.toLowerCase().equals("l")
                    || ans.toLowerCase().equals("n"))) {
                    System.out.println("Wrong answer");
            }
        } while (!(ans.toLowerCase().equals("l")
                    || (ans.toLowerCase().equals("n"))));

        if (ans.toLowerCase().equals("l")) {
            likes++;
            System.out.println("Answer recorded successfully");
            delay(2500);
        }
    }   

    public static void delay(long delayDuration) {
        try {
            Thread.sleep(delayDuration);
        } catch (InterruptedException e) {
            System.err.println("The operation was interrupted");
        }
    }

}
