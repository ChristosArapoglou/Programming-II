package com.dmst.president;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;
import java.text.DateFormat;


class Post {
	
	private java.sql.Date creationDate; //TODO: add time to instance variables
	private int likes = 0;  // TODO: later
	private String text;
	private String creator; // User's username

	
	// TODO: write void createPost method that invokes constructor
	public Post( String text, String creator) {
		creationDate = new java.sql.Date(System.currentTimeMillis());
		this.text = text;
		this.creator = creator;
	}

	@Override
	public String toString() {       // TODO: format post 
		return creationDate.toString();
	}
	
	public static void main(String[] args) {  // dummy main :)
		
		Post p = new Post("enjefefn", "gousis" );
		System.out.println(p);
	}
	
	/* public void react() {
		this.likes++;
	} */ 
	
}


