package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	public static Connection getMySqlConnection() throws SQLException {
		String connectionString = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String password = "m@h@gon";
		return DriverManager.getConnection(connectionString, user, password);
				
	}

}
