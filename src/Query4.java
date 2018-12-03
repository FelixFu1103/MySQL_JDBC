/**
 * Query 4
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query4 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      jdbc.connect();
	      
	      // Execute a query
	      stmt = jdbc.connection.createStatement();

	      // Create new author
	      String query4Author = "INSERT INTO Authors (ID, firstName, lastName)" +
	      				       "VALUES ('16', 'Jon', 'Krakauer')"; 
	      stmt.executeUpdate(query4Author);
	      System.out.println("Added Author 'Jon Krakauer'");

	      String query = "SELECT * FROM authors"; 
	      
	      ResultSet rs1 = stmt.executeQuery(query);
	      
	      
	      while (rs1.next()) {
	          	int id = rs1.getInt("ID");
	            String firstName = rs1.getString("firstName");
	            String lastName = rs1.getString("lastName");
	            System.out.println(id + "\t" + firstName + "\t" + lastName);
	          }

	      

	   } catch(SQLException se) {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      jdbc.close();
	   }
	}
}