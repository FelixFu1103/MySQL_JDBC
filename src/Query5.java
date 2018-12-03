/**
 * Query 5: Edit/Update the existing information about an author
 * CS 157A
 */


import java.sql.*;
import java.util.*;

public class Query5 {

	public static void main(String[] args) {
		Statement stmt = null;
		try{

			// Open a connection
			jdbc.connect();

			// Execute a query
			stmt = jdbc.connection.createStatement();

			String query = "SELECT * FROM authors"; 

			// Prints the original Value
			ResultSet rs1 = stmt.executeQuery(query);
			System.out.println("Author's name changed from : ");
			while(rs1.next()){
				int id = rs1.getInt("ID");
				String firstName = rs1.getString("firstName");
				String lastName = rs1.getString("lastName");
				System.out.println(id + "\t" + firstName + "\t" + lastName);
				if(id == 16){
					String firstName1 = rs1.getString("firstName");
					String lastName1 = rs1.getString("lastName");
					System.out.println(id + "\t" + firstName1 + "\t" + lastName1);
				}
			}

			// Update Author's information
			String query5Author = "UPDATE Authors SET firstName = 'AK' WHERE ID= 16";
			stmt.executeUpdate(query5Author);
			
			// Prints the Updated Value
			ResultSet rs2 = stmt.executeQuery(query);
			while(rs2.next()){
				int id = rs2.getInt("ID");
				if(id == 16){
					System.out.println(" to ");
					
					String updatedFName = rs2.getString("firstName");
					String updatedLName = rs2.getString("lastName");
					System.out.println(id + "\t" + updatedFName + "\t" + updatedLName);
					
				}
			}
			
			System.out.println();
			// Prints the Update Author table
			rs2 = stmt.executeQuery(query);
			System.out.println("----***-----");
			System.out.println("Show all Authors");
			System.out.println();
			while (rs2.next()) {
				int id = rs2.getInt("ID");
				String firstName = rs2.getString("firstName");
				String lastName = rs2.getString("lastName");
				System.out.println(id + "\t" + firstName + "\t" + lastName);
			}
			
			String query5AuthorToOriginal = "UPDATE authors SET firstName = 'Jon' WHERE ID= 16";
			stmt.executeUpdate(query5AuthorToOriginal);
		
		} catch(SQLException se) {
			//Handle errors for JDBC
			System.out.println("Connection Failed!");
			se.printStackTrace();
		} finally {
			//finally block used to close resources
			jdbc.close();
		}
	}
}
