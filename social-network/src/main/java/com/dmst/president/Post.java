package com.dmst.president;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Connection;

/**
 * This class is used to design and format posts made by users.
 */
class Post {
    /**
     * Post's creation date in String form.
     */
    private final String strDate;
    /**
     * Post's text (user's thoughts).
     */
    private final String text;
    /**
     * Post's creator (user).
     */
    private final String creator;
    private static final Scanner IN = new Scanner(System.in);
    private static final long DELAYDURATION = 2500;
    /**
     * This constructor is used to allocate values in Post's
     * fields and determine each post's unique features.
     */
    protected Post(final String creator) {
        final Date creationDate = new Date();
        final DateFormat dateFormat = new SimpleDateFormat(
                                "dd-MM-yyyy hh:mm a");
        this.strDate = dateFormat.format(creationDate);
        System.out.println("Enter your thoughts :");
        this.text = IN.nextLine();
        this.creator = creator;
    }
    /**
     * This method is used to display all stored posts on user's
     * screen with a certain format. All post features are displayed:
     * text, creator username, date of creation and total likes.
     */
    protected static void displayPost(final String text, final String creator,
    final String strDate, final int likes) {
        final int lineLimit = 70;
        final StringBuffer sb = new StringBuffer(text);
        final int lines = sb.length() / 70;
        for (int i = 1; i <= lines; i++) {
            sb.insert(i * lineLimit, "\n");
        }
        System.out.println(String.format("--------------------------------"
            + "--------------------------------------%n"
            + "User %s posted:%40s%n%n%s%n%70s%n"
            + "--------------------------------------"
            + "--------------------------------",
            creator, strDate, sb.toString(), "Likes:" + likes));
    }
    /**
     * This method is used to enable user-post interaction.
     * The active user states whether or not he likes the post he
     * just saw. The parameters are only needed to call the
     * DatabasePost.incrementLikes method.
     */
    protected static void react(final Connection dbcon,
    final String sn, final int postNumber) {
        String ans;
        do {
            System.out.println(
                "Press <L> to like this post or <N> to move to the next Post");
            ans = IN.nextLine();
            if (!(ans.toLowerCase().equals("l")
            || ans.toLowerCase().equals("n"))) {
                System.out.println("Wrong answer.");
            }
        } while (!(ans.toLowerCase().equals("l")
         || (ans.toLowerCase().equals("n"))));
        if (ans.toLowerCase().equals("l")) {
            if (DatabasePost.ensureUniqueLikes(dbcon, sn, postNumber)) {
                // If the user tries to like a post he has already liked
                System.out.println("You have already liked this post!");
                UniPost.delay(DELAYDURATION);
            } else {
                DatabasePost.incrementLikes(dbcon, postNumber);
                DatabasePost.markPostAsLiked(dbcon, sn, postNumber);
                System.out.println("Answer recorded successfully");
                UniPost.delay(DELAYDURATION);
            }
        }
    }
}
