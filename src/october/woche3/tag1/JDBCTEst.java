package october.woche3.tag1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import helper.DBHelper;

public class JDBCTEst {

	public static void main(String[] args) {
		
		
		
		List<City> cities = new ArrayList<>();
		
		try {
			Connection conn = DBHelper.getMySqlConnection();
			if(conn!=null) {
				System.out.println("not null");
			}
			DatabaseMetaData dbm = conn.getMetaData();
			System.out.println(dbm.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println(dbm.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY));
			System.out.println(dbm.supportsResultSetType(ResultSet.CONCUR_UPDATABLE));
			System.out.println(dbm.supportsResultSetType(ResultSet.CONCUR_READ_ONLY));
			String select = "select * from city";
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(select);
	

			while(rs.next()) {
				City city = new City();
				city.setId(rs.getInt(1));
				city.setCountryCode(rs.getString(3));
				city.setName(rs.getString(2));
				city.setDistrict(rs.getString(4));
				city.setPopulation(rs.getInt(5));
				cities.add(city);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//cities.forEach(System.out::println);
		System.out.println(cities.size());

	}

}
