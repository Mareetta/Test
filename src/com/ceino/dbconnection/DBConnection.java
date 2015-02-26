package com.ceino.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		Statement stmt=null;
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/test1","admin", "admin123");
			stmt = connection.createStatement();
	        stmt.execute("INSERT INTO customers (CUSTOMER_ID,CUSTOMER_NAME,CITY,COUNTRY) "
	                            + "VALUES (6,'Lokesh','Gupta','INDIA')");
	        
	        Statement stmt1 = connection.createStatement();
			/*String sql = "INSERT INTO customers" +
	                   "VALUES (1985, 'Zara', 'A', 'b')";*/
			/*stmt1.executeUpdate(sql);*/
	        
	        stmt1.execute("INSERT INTO customers (CUSTOMER_ID,CUSTOMER_NAME,CITY,COUNTRY) "
                    + "VALUES (5,'Lokesh','Ga','INDIA')");
	        
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
			
		
		 
	}
}