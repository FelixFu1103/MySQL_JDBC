/**
 * Query 6
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query6 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      jdbc.connect();
	      
	      // Execute a query
	      stmt = jdbc.connection.createStatement();

	      // Create new publisher for new title
	      String query6Publisher = "INSERT INTO Publishers (PublisherID, Name)" +
	      				       "VALUES ('16', 'Jeff Hardy')"; 
	      stmt.executeUpdate(query6Publisher);
	      System.out.println("Added Publisher 'Jeff Hardy' ");

	      
	      // Add new title
	      String query6Title = "INSERT INTO Titles (isbn, title, Edition, Year, publisherID, price)" +
	      				       "VALUES ('0798725631', 'Shanghai Girls', '2', '2010', (SELECT PublisherID FROM Publishers WHERE Name = 'Jeff Hardy'), '10.90')"; 
	      stmt.executeUpdate(query6Title);
	      System.out.println("Added title 'Shanghai Girls' ");


	      // Link new title to author (Lisa See)
	      String query6authorISBN = "INSERT INTO AuthorISBN (AuthorID, ISBN)" +
	      				       "VALUES ((SELECT ID FROM Authors WHERE firstName = 'Lisa' AND lastName = 'See'), '0798725631')"; 
	      stmt.executeUpdate(query6authorISBN);
	      System.out.println("Added AuthorISBN relation");

	      // Print modified tables
	      String exampleQuery2 = "SELECT * FROM Titles"; 
	      System.out.println("Titles:");
	      ResultSet rs2 = stmt.executeQuery(exampleQuery2);
          while (rs2.next()) {
            String isbn = rs2.getString("isbn");
            String title = rs2.getString("title");
            int edition = rs2.getInt("Edition");
            String year = rs2.getString("year");
            int pubID = rs2.getInt("publisherID");
            String price = rs2.getString("price");
            System.out.println(isbn + "\t" + edition + "\t" + year + "\t"  + pubID + "\t" + "\t" + price + "\t" + title);
          }
/*
	      String exampleQuery3 = "SELECT * FROM Publishers"; 
	      System.out.println("Publishers:");
	      ResultSet rs3 = stmt.executeQuery(exampleQuery3);
          while (rs3.next()) {
          	int id = rs3.getInt("publisherID");
            String name = rs3.getString("Name");
            System.out.println(id + "\t" + name);
          }

	      String exampleQuery4 = "SELECT * FROM AuthorISBN";
	      System.out.println("AuthorISBN:"); 
	      ResultSet rs4 = stmt.executeQuery(exampleQuery4);
          while (rs4.next()) {
          	int id = rs4.getInt("AuthorID");
          	String isbn = rs4.getString("ISBN");
            System.out.println(id + "\t" + isbn);
          }
*/
	   } catch(SQLException se) {
	      //Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      //finally block used to close resources
	      jdbc.close();
	   }
	}
}