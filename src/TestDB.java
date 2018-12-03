/**
 * CS 157A
 */

import java.sql.*;
import java.util.*;

public class TestDB {

  public static void main(String[] argv) {

	System.out.println("-------MySQL JDBC Connection Testing -----------");

	try {
		jdbc.connect();
	} catch (SQLException e) {
		System.out.println("Connection Failed!");
		e.printStackTrace();
		return;
	}

	jdbc.close();
  }
}