/**
 * Query 8 
 * CS 157A
 */
import java.sql.*;
import java.util.*;

public class Query8 {
   
   public static void main(String[] args) {
	   Statement stmt = null;
       try{

           // Open a connection
           jdbc.connect();

           // Execute a query
           stmt = jdbc.connection.createStatement();

           // Display all current information to see original listing
           String query8View = "SELECT * FROM publishers;";

           System.out.println("Show all publishers");

           ResultSet rs1 = stmt.executeQuery(query8View);

           while (rs1.next()) {
               int id = rs1.getInt("PublisherID");
               String pubN = rs1.getString("Name");
               System.out.println(id + "\t" + pubN);
           }
           
           System.out.println("Starting update the publisher!");
           String query8Publisher = "UPDATE publishers SET Name='Luka' WHERE publisherID = 3";

           // executeUpdate to manipulate data information for update command
           stmt.executeUpdate(query8Publisher);
          // System.out.println("Command being executed: " + query8Publisher);
           ResultSet rs2 = stmt.executeQuery(query8View);
           while (rs2.next()) {
               int id = rs2.getInt("PublisherID");
               String pubName = rs2.getString("Name");
               System.out.println(id + "\t" + pubName);
           }
           
           // Reset the Information
           String resetQuery = "UPDATE publishers SET Name='Signet' WHERE publisherID = 3";
           System.out.println("Reset the publisher to original one!");
           stmt.executeUpdate(resetQuery);
           
           ResultSet rs3 = stmt.executeQuery(query8View);

           while (rs3.next()) {
               int id = rs3.getInt("PublisherID");
               String pubN = rs3.getString("Name");
               System.out.println(id + "\t" + pubN);
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