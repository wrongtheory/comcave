package october.woche2.tag3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import helper.*;
public class JDBCTest2 {

	public static void main(String[] args) {
		
		int id = 4082;
		String name = "Wismar";
		String countryCode = "DEU";
		String district ="Sachsen";
		int population = 23_313;
		
		try {
			Connection conn = DBHelper.getMySqlConnection();
			
			String update = "insert into city values(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(update);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, countryCode);
			pstmt.setString(4, district);
			pstmt.setInt(5, population);
			
			boolean b = pstmt.execute();
			System.out.println("b: " + pstmt.getUpdateCount());
			
			
		} catch (SQLException e) {
			System.out.println("cannt connect");
			e.printStackTrace();
		}
		System.out.println("Connected");

	}

}
