
/*
 * CS 157A
 */

import java.util.*;
import java.sql.*;

public class jdbc {

	public static Connection connection = null;

    public static void connect() throws SQLException {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Mysql JDBC Driver's been registered!");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			throw new SQLException();
		}
    	connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false","root", "66666666");
		if(connection == null) {
			throw new SQLException();
		} else {
			System.out.println("Successfully connected");
		}
    }

    public static void close() {
    	try {
    		if(connection != null) {
    			connection.close();
				System.out.println("Connection's closed");
    		}
		} catch (SQLException e) {
			System.out.println("Failed to close connection!");
		}
    }
    
}