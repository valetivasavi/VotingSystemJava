package com.voting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionProvider1 {
	static String driver;
	static String userName;
public static Connection getConnectionWithDB() {
	Connection con=null;
	try {
		FileReader fr = new FileReader("dbInfo1.properties");
		Properties pr = new Properties();
		pr.load(fr);
		driver = pr.getProperty("driver");
		userName = pr.getProperty("dbUser");
		Class.forName(driver);
		con=DriverManager.getConnection(pr.getProperty("url"),userName,pr.getProperty("dbPassword"));
		System.out.println("Connection Established "+con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return con;
}
public static void main(String[] args) {
	ConnectionProvider1.getConnectionWithDB();
	System.out.println("end of main");
}
}
