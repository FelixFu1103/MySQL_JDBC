/**
 * Query 2
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class Query2 {

    public static void main(String[] args) {
        Statement stmt = null;
        try{

            // Open a connection
            jdbc.connect();

            // Execute a query
            stmt = jdbc.connection.createStatement();

            // Create new author
            String query2Author = "SELECT Name FROM Publishers";

            System.out.println("Show all publishers");

            ResultSet rs1 = stmt.executeQuery(query2Author);

            while (rs1.next()) {
               // int id = rs1.getInt("PublisherID");
                String pubName = rs1.getString("Name");
                System.out.println( pubName);
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