package october.woche3.tag2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Aufgabe {

	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","m@h@gon");
			
			Statement stmt = conn.createStatement();
			String insert = "insert into user values('marco','topSecret');";
			stmt.execute(insert);
			insert = "insert into user values(?,?);";
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, "marco");
			pstmt.setString(2, "geheim");
			
			
			//ResultSetMetaData rs = stmt.execute(insert);
			ResultSet rs = stmt.executeQuery(insert);

			if(rs==null) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
