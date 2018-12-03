/**
 * Query1
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query1 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      jdbc.connect();
	      
	      // Execute a query
	      stmt = jdbc.connection.createStatement();
	      
	      /*
	       * Creates the query to get alphabetically all rows from authors by their first and last name
	       * 
	       * SELECT *
	       * FROM authors
	       * ORDER BY firstName, lastName
	       */
	      String query = "SELECT * FROM Authors ORDER BY lastName , firstName"; 

	      
	      System.out.println("Alphabetically order all rows by last and first name:");
	      
	      ResultSet rs1 = stmt.executeQuery(query);
	      
	      
	      while (rs1.next()) {
	          	int id = rs1.getInt("ID");
	            String firstName = rs1.getString("lastName");
	            String lastName = rs1.getString("firstName");
	            System.out.println(id + "\t" + firstName + "\t\t" + lastName);
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