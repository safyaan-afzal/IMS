package com.qa.IMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDqueries {

	// To carry out CRUD queries - where we connect to the the db
	// Four main things needed:
	// - open the connection
	// - write your query/statement - CRUD
	// - Execute query.
	// - close connection

	private Connection conn;// has a driver manager class which contains the methods to connect to db
	private Statement stmt;// allows us to prepare the query we want to execute
	private ResultSet rs; // Crucial for when returning multiple rows from a database table

	// open connection in the constructor - initialises everything
	public CRUDqueries() {
		try {
			conn = DriverManager.getConnection(DBconfig.URL, DBconfig.USER, DBconfig.PASS);
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}

	// Need a way to run our queries - call specific methods from the Statement
	// class
	// - executeQuery - retrieves info -> READ
	// - executeUpdate - passes into through and returns nothing -> CREATE, UPDATE,
	// DELETE

	// CREATE - INSERT INTO .... -> returns nothing, just says "query ok"
	public void create(Customer c) {

			String createStmt = "INSERT INTO customer(first_name, last_name, address, email, phone) VALUES('" + c.getFirstName() + "','" + c.getLastName()
					+ "','" + c.getAddress() + "','" + c.getEmail() + "','" + c.getPhone() + "');";
			try {
				stmt.executeUpdate(createStmt);
				System.out.println("Create statement executed");
			} catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}
		}
	
	// READ - SELECT ..... -> executeQuery
	public void read() {
		String readStmt = "SELECT * FROM customer;";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First name: " + rs.getString("first_name"));
				System.out.println("Last name: " + rs.getString("last_name"));
				System.out.println("Address: " + rs.getString("address"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void readById(Customer c) {
		String readByIDStmt = "SELECT * FROM customer where id = " + c.getId() + ";";
		try {
			rs = stmt.executeQuery(readByIDStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First name: " + rs.getString("first_name"));
				System.out.println("Last name: " + rs.getString("last_name"));
				System.out.println("Address: " + rs.getString("address"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void readByName(Customer c) {
		String readByNameStmt = "SELECT * FROM customer where first_name = '" + c.getFirstName() + "';";
		try {
			rs = stmt.executeQuery(readByNameStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("First name: " + rs.getString("first_name"));
				System.out.println("Last name: " + rs.getString("last_name"));
				System.out.println("Address: " + rs.getString("address"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	// UPDATE - UPDATE ..... -> executeUpdate
	public void update(Customer c, String updateVal) {
		String updateStmt = "UPDATE customer SET first_name = '" + updateVal + "' WHERE id = " + c.getId() + ";";
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}
	
	// DELETE - DELETE ..... -> executeUpdate
	public void delete(Customer c) {
		String delStmt = "DELETE FROM customer WHERE id=" + c.getId() + ";";
		try {
			stmt.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
			autoInc();
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}
	
	public void autoInc() {
		String autoIncStmt = "ALTER TABLE customer AUTO_INCREMENT=1;";
		try {
			stmt.executeUpdate(autoIncStmt);
			System.out.println("Auto increment statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}

	}
	

	// close the connection
	public void closeConn() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
