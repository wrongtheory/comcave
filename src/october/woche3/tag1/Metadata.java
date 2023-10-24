package october.woche3.tag1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import helper.DBHelper;

public class Metadata {

	public static void main(String[] args) {
		
		
		
		try(Connection conn = DBHelper.getMySqlConnection();
			Scanner sc = new Scanner(System.in);) 
		{
			
			Statement stmt = conn.createStatement();
			System.out.println("Bitte SQL_Statement eingeben");
			String sql = sc.nextLine();
			//String select = "Select Code, Name, Continent, SurfaceArea,Capital from country";
			//ResultSet rs =  stmt.executeQuery(select);
			boolean b = stmt.execute(sql);
			if(b) {
				ResultSet rs =  stmt.getResultSet();
				ResultSetMetaData rsmeta = rs.getMetaData();
				int columnCount = rsmeta.getColumnCount();
				
				for(int i=1;i<=columnCount;i++) {
					System.out.println(rsmeta.getColumnName(i) + " ");
				}
				
				while(rs.next()) {
					for(int i=1;i<=columnCount;i++) {
						System.out.print(rs.getObject(i) + " ");
					}
					System.out.println();
				}
			}else {
				int updateCount = stmt.getUpdateCount();
				System.out.println("UpdateCount: " + updateCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
