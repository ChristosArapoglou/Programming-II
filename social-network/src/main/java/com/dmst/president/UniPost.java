package com.dmst.president;

public class UniPost {
    public static void main( String[] args ) {
        Post p = new Post("Alexis Mardas");  // TODO(SQL): username from sql
        p.displayFullPost();
        System.out.println("End");
    }
}
