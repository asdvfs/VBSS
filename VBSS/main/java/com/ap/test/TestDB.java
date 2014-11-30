package com.ap.test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
	
	public static void main(String[] args) throws Exception {
		
		new com.mysql.jdbc.Driver();
		DriverManager.getConnection("jdbc:mysql://localhost:3306/kjsb", 
				"root", "xiger");
		
		
		
	}

}
