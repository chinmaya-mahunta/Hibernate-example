package com.cm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres","admin");  
			System.out.println("Connected..");
			//here sonoo is database name, root is username and password  
			/*Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/  
			con.close();  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		

	}

}
