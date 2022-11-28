import java.sql.*;

public class DatabaseTest {
	public static void main(String[] args) {
		Connection dbcon = Database.initiateConnection();
		Database.insertQuery(dbcon, "8210107", "giorgos", "papageorgiou", "g_pap", "123", "dmst", "2003-9-9");
		Database.selectQuery(dbcon, "SN", "username");
	}
}
