/*
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class GetAllTables {
   
   public static void main(String[] args) {
	   Statement stmt = null;
	   try{

	      // Open a connection
	      jdbc.connect();
	      
	      // Execute a query
	      stmt = jdbc.connection.createStatement();
	      
	      String exampleQuery1 = "SELECT * FROM Authors where ID > 0";
	      System.out.println("---------- Authors Table ----------");
	      System.out.println("ID:	Authors:");
	      ResultSet rs1 = stmt.executeQuery(exampleQuery1);
          while (rs1.next()) {
          	int id = rs1.getInt("ID");
            String firstName = rs1.getString("firstName");
            String lastName = rs1.getString("lastName");
            System.out.println(id + "\t" + firstName + "\t" + lastName);
          }
	      
          System.out.println("------------------ Titles Table ------------------");
	      String exampleQuery2 = "SELECT * FROM Titles"; 
	      System.out.println("ISBN" + "\t"+ "   " + "Edition" + "\t" + "Year" + "\t" + "PublisherID" + "\t" + "Price" + "\t"+ "Titles:");
	      ResultSet rs2 = stmt.executeQuery(exampleQuery2); 
          while (rs2.next()) {
            String isbn = rs2.getString("isbn");
            String title = rs2.getString("title");
            int edition = rs2.getInt("Edition");
            String year = rs2.getString("Year");
            int pubID = rs2.getInt("PublisherID");
            String price = rs2.getString("Price");
            System.out.println(isbn + "\t" + edition + "\t" + year + "\t"  + pubID + "\t" + "\t" + price + "\t" + title );
          }
          
          System.out.println("---------- Publishers Table ----------");
	      String exampleQuery3 = "SELECT * FROM Publishers where PublisherID > 0"; 
	      System.out.println("ID:" + "\t" + "Publishers: ");
	      ResultSet rs3 = stmt.executeQuery(exampleQuery3);
          while (rs3.next()) {
          	int id = rs3.getInt("PublisherID");
            String name = rs3.getString("Name");
            System.out.println(id + "\t" + name);
          }
          
          System.out.println("---------- AuthorsISBN Table ----------");
	      String exampleQuery4 = "SELECT distinct * FROM AuthorISBN order by AuthorID";
	      System.out.println("ID" + "\t" + "ISBN:"); 
	      ResultSet rs4 = stmt.executeQuery(exampleQuery4);
          while (rs4.next()) {
          	int id = rs4.getInt("AuthorID");
          	String isbn = rs4.getString("ISBN");
            System.out.println(id + "\t" + isbn);
          }

	   } catch(SQLException se) {
	      // Handle errors for JDBC
	      se.printStackTrace();
	   } finally {
	      // Finally block, used to close resources
	      jdbc.close();
	   }
	}
}