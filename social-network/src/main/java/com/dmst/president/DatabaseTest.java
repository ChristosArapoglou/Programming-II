package com.dmst.president;

import java.sql.*;

public class DatabaseTest {
	public static void main(String[] args) {
		Connection dbcon = Database.initiateConnection();
		DatabasePost.createPost(dbcon, 54, "8210009", "Awesome application!");
		DatabasePost.selectPost(dbcon, "user_AM", "text");
	}
}
