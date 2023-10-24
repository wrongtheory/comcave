package october.woche2.tag3;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		
		System.out.println("Driver loaded");
		
		String connectionString = "jdbc:mysql://localhost:3306/world";
		String user = "root";
		String password = "m@h@gon";
		
		int id = 4081;
		String name = "Quedlinburg";
		String countryCode = "DEU";
		String district = "Sachsen-Anhalt";
		int population = 23_313;
		
		
		try {
			Connection connection = DriverManager.getConnection(connectionString, user, password);
			Statement statement = connection.createStatement();
			//String update = "insert into city values(4080,'Neustadt','DEU','NRW',3500)";
			//String update = "insert into city values(" + id + ",'" + name  + "', '" + countryCode + "','" + district + "'," + population + ")";
			//String update = "update city set District='Bayern' where District = 'Baijeri'";
			//int result = statement.executeUpdate(update);
			//System.out.println(result);
			
			//String update = "update city set District='Berlin' where District = 'Berliini'";
			String delete = "delete from city where name = 'Neustadt' and CountryCode = 'DEU'";
			int result = statement.executeUpdate(delete);
			System.out.println("result: " + result);
			
		} catch (SQLException e) {
			System.out.println("Can't connect to the database");
			e.printStackTrace();
		}
		
		System.out.println("Connected to the database");
		
//	       try{
//	            String dbUrl="jdbc.mysql://localhost:3306/EMPLOYEE";
//	            String username="root";
//	            String password="avinash";
//	            Class.forName("com.mysql.jdbc.Driver");
//	            Connection myconnection=DriverManager.getConnection(dbUrl,username,password);
//	            Statement mystatement=myconnection.createStatement();
//	            ResultSet myresultset=mystatement.executeQuery("select * from EMPLOYEE");
//	        }catch(Exception e){
//	        System.out.println(e);
//	        }
	 

	}

}
