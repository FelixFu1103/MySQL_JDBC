/**
 * JDBC-Books
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class InsertToTables {

	public static void main(String[] argv) {
		updateTables();
	}

	public static void updateTables(){
		try {
			jdbc.connect();
			Statement stmt = jdbc.connection.createStatement();
			updateAuthorsTable(stmt);
			updateAuthorIsbnTable(stmt);
			updateTitlesTable(stmt);
			updatePublishersTable(stmt);
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		jdbc.close();
	}

	private static void updateAuthorsTable(Statement stmt) {
		String authorFirstNames[] = { "Camille", "Conrad", "Bruce", "Ignacio","Mildred", "Archie", "Cameron", "Shaun", "Eunice",
				"Iris", "Flora", "Eileen", "Gina", "Carla", "kara" };
		String authorLastNames[] = { "Gonzalez", "Craig", "Alexandar", "Mccormick", "Mann", "Copeland", "Campbell",
				"Farmer", "Fowler", "Dean", "Graham", "Wilson", "Jennings", "Gibbs", "Gomez" };
		// reset the auto increment
		String updateAuthorsTable = "ALTER TABLE Authors AUTO_INCREMENT = 1";
		try {
			stmt.executeUpdate(updateAuthorsTable);
		} catch (SQLException e) {
			System.out.println("Execute Update Failed!");
			e.printStackTrace();
			return;
		}
		for (int i = 1; i <= authorFirstNames.length; i++) {
			updateAuthorsTable = "INSERT INTO Authors (firstName, lastName)" + "VALUES ('" + authorFirstNames[i - 1]
					+ "', '" + authorLastNames[i - 1] + "');";
			try {
				stmt.executeUpdate(updateAuthorsTable);
			} catch (SQLException e) {
				System.out.println("Execute Update Failed!");
				e.printStackTrace();
				return;
			}
		}
	}

	private static void updateAuthorIsbnTable(Statement stmt) {
		String isbn[] = { "0489262543", "1568352764", "1864753901", "0822095378", "1086492749", "0731980381",
				"1780287429", "0906389073", "1896439739", "1905323745", "1843675439", "0865468746", "0765896436",
				"0786543279", "0165908657" };
		for (int i = 1; i <= isbn.length; i++) {
			String updateAuthorISBNTable = "INSERT INTO AuthorISBN (AuthorID, isbn)" + "VALUES (" + i + ", '"
					+ isbn[i - 1] + "')";
			try {
				stmt.executeUpdate(updateAuthorISBNTable);
			} catch (SQLException e) {
				System.out.println("Execute Update Failed!");
				e.printStackTrace();
				return;
			}
		}
	}

	private static void updateTitlesTable(Statement stmt) {
		String isbn[] = { "0489262543", "1568352764", "1864753901", "0822095378", "1086492749", "0731980381",
				"1780287429", "0906389073", "1896439739", "1905323745", "1843675439", "0865468746", "0765896436",
				"0786543279", "0165908657" };
		String editionNumber[] = { "8", "10", "10", "4", "1", "5", "3", "3", "2", "7", "5", "14", "1", "4", "1" };
		String year[] = { "2003", "2009", "2002", "2014", "2002", "2011", "2015", "1961", "1999", "1995", "2014",
				"2017", "1999", "2004", "1996" };
		String publisherID[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };
		String price[] = { "13.49", "8.99", "8.00", "10.76", "13.60", "8.60", "11.90", "7.64", "12.51", "9.98", "8.49",
				"9.95", "7.47", "6.99", "9.99" };
		String title[] = { "Nature and Selected Essays", "The Da Vinci Code", "Pride and Prejudice", "The Martian",
				"Cannery Row", "The Girl with the Dragon Tattoo", "Steve Jobs", "1984",
				"Slaughterhouse-Five", "The Old Man and The Sea", "Sycamore Row", "It: A Novel",
				"Harry Potter and the Sorcerer’s Stone", "The Great Gatsby", "Into the Wild" };

		for (int i = 0; i < isbn.length; i++) {
			String updateTitlesTable = "INSERT INTO Titles (isbn, title, Edition, year, publisherID, price)"
					+ "VALUES ('" + isbn[i] + "', '" + title[i] + "', " + editionNumber[i] + ",'" + year[i] + "',"
					+ publisherID[i] + "," + price[i] + ")";
			try {
				stmt.executeUpdate(updateTitlesTable);
			} catch (SQLException e) {
				System.out.println("Execute Update Failed!");
				e.printStackTrace();
				return;
			}
		}
	}

	private static void updatePublishersTable(Statement stmt) {
		String publishers[] = { "Vintage Crime", "Dial Press", "Signet", "Scholastic", "Broadway", "Dell Books",
				"Scribner", "Anchor", "Penguin", "Goose", "Houghton Mifflin", "Pearson", "Oxford", "Bloomsbury", "Pan" };
		// reset the auto increment
		String updatePublishersTable = "ALTER TABLE Publishers AUTO_INCREMENT = 1";
		try {
			stmt.executeUpdate(updatePublishersTable);
		} catch (SQLException e) {
			System.out.println("Execute Update Failed!");
			e.printStackTrace();
			return;
		}
		for (int i = 0; i < publishers.length; i++) {
			updatePublishersTable = "INSERT INTO Publishers (Name)" + "VALUES ('" + publishers[i] + "')";
			try {
				stmt.executeUpdate(updatePublishersTable);
			} catch (SQLException e) {
				System.out.println("Execute Update Failed!");
				e.printStackTrace();
				return;
			}
		}
	}
}
