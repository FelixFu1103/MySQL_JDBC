/**
 * Query 7
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query7 {
	
	public static void main(String[] args){
		Statement stmt = null;
		try{
			
			jdbc.connect();
			
			stmt = jdbc.connection.createStatement();
			
			String query4Publisher = "INSERT INTO Publishers(PublisherID, Name)" + "VALUES('16', 'New Yorker')";
			
			stmt.executeUpdate(query4Publisher);

			String query = "SELECT * FROM publishers"; 

	      
	      System.out.println("Added publisher 'New Yorker':");
	      
	      ResultSet rs1 = stmt.executeQuery(query);
	      
	      
	      while (rs1.next()) {
	          	int id = rs1.getInt("publisherID");
	            String publisherName = rs1.getString("Name");
	            System.out.println(id + "\t" + publisherName);
	          }

		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			jdbc.close();
		}
	}

}