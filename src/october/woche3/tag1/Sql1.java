package october.woche3.tag1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import helper.DBHelper;

public class Sql1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DBHelper.getMySqlConnection();
			Statement stmt = conn.createStatement();
			String select = "Select Code, Name, Continent, SurfaceArea,Capital from country";
			ResultSet rs =  stmt.executeQuery(select);
			rs.next();
			String name = rs.getString("Name");
			System.out.println("name: " + name);
			
			int surface;
			
			
			while(rs.next()) {
				name = rs.getString("Name");
				surface = rs.getInt("SurfaceArea");
				System.out.println("code: " + rs.getString(1) + " name: " + name + " Surface: " + surface);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
