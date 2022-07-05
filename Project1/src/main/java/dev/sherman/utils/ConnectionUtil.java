package dev.sherman.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//This class will define the methods needed to create
//a connection to our DB.
//we are going to make ConnectionUtil using the Singleton Design Pattern
//only one instance of the class exists throughout the program
public class ConnectionUtil {
	
	private static ConnectionUtil cu;
	private static Properties dbProps;
	
	//private constructor
	private ConnectionUtil() {
		//Initializing the Properties object to hold our DB credentials
		dbProps = new Properties();
		
		//Streaming credentials from connection.properties file to this object
		InputStream props = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
		
		try {
			dbProps.load(props);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//public getter to return us an instance of this class -> a ConnectionUtil
	public static synchronized ConnectionUtil getConnectionUtil() {
		//checking if an instance does not already exist
		if(cu == null) {
			cu = new ConnectionUtil();
		}
		//otherwise return the existing instance
		return cu;
	}
	//Method establishing a connection to the DB
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName(dbProps.getProperty("driver"));
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//get credentials from the ConnectionUtil's properties
		String url = dbProps.getProperty("url");
		String username = dbProps.getProperty("username");
		String password = dbProps.getProperty("password");
		
		//use credentials and DriverManager to connect to our DB instance
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// the below code is just to manually test that we can make a connection
		// don't put this in your project or leave it there
//		public static void main(String[] args) {
//			
//			Connection connection = getConnectionUtil().getConnection();
//		
//			if (connection != null) {
//				System.out.println("Connection Successful");
//			} else {
//				System.out.println("Something went wrong");
//			}
//			
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//}
}
