package com.qa.IMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDqueries implements Create, Update, Delete {

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
	
	public void updateData(String updateStmt, String stmtType) {
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println(stmtType+ " statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}

	@Override
	public void create(Customer c) {

			updateData("INSERT INTO customer(first_name, last_name, address, email, phone) VALUES('" + c.getFirstName() + "','" + c.getLastName()
					+ "','" + c.getAddress() + "','" + c.getEmail() + "','" + c.getPhone() + "');", "create");
		}
	
	@Override
	public void create(Product p) {
		
		updateData("INSERT INTO product(name, category, price) VALUES('" + p.getName() + "','" + p.getCategory()
		+ "'," + p.getPrice() + ");", "create");
	}

	public void printData(String readByIDStmt) {
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
	
	// READ - SELECT ..... -> executeQuery
	public void read() {
		printData("SELECT * FROM customer;");
	}
	
	public void readById(Customer c) {
		printData("SELECT * FROM customer where id = " + c.getId() + ";");
	}
	
	public void readByName(Customer c) {
		printData("SELECT * FROM customer where first_name = '" + c.getFirstName() + "';");
	}
	
	// UPDATE - UPDATE ..... -> executeUpdate
	@Override
	public void update(Customer c, String updateVal) {
		updateData("UPDATE customer SET first_name = '" + updateVal + "' WHERE id = " + c.getId() + ";", "Update");
	}
	
	@Override
	public void update(Product p, String updateVal) {
		updateData("UPDATE product SET name = '" + updateVal + "' WHERE id = " + p.getId() + ";", "Update");
	}
	
	// DELETE - DELETE ..... -> executeUpdate
	@Override
	public void delete(Customer c) {
		updateData("DELETE FROM customer WHERE id=" + c.getId() + ";", "Delete");
		autoInc("customer");
	}
	
	@Override
	public void delete(Product p) {
		updateData("DELETE FROM product WHERE id=" + p.getId() + ";", "Delete");
		autoInc("product");
	}
	
	//Resets the auto increment in the customer table so ID's are organised if a customer is deleted.
	public void autoInc(String tableName) {
		updateData("ALTER TABLE " + tableName + " AUTO_INCREMENT=1;", "");
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
