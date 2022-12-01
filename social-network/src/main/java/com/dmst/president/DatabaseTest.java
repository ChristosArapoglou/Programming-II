import java.sql.*;

public class DatabaseTest {
	public static void main(String[] args) {
		//A dummy main created to test the functionality of Database.java
		Connection dbcon = Database.initiateConnection();
		Database.insertUser(dbcon, "8210107", "giorgos", "papageorgiou", "g_pap", "123", "dmst", "2003-9-9");
		Database.selectUser(dbcon, "SN", "username");
	}
}
