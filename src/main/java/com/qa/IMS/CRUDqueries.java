package com.qa.IMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDqueries implements Create, Read, Update, Delete {

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
					+ "','" + c.getEmail() + "','" + c.getAddress() + "','" + c.getPhone() + "');", "create");
		}
	@Override
	public void create(Product p) {
		
		updateData("INSERT INTO product(name, category, price) VALUES('" + p.getName() + "','" + p.getCategory()
		+ "'," + p.getPrice() + ");", "create");
	}
	

	public void printProdData(String readByIDStmt) {
		try {
			rs = stmt.executeQuery(readByIDStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Category: " + rs.getString("category"));
				System.out.println("Price: " + rs.getBigDecimal("price"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void printCustData(String readByIDStmt) {
		try {
			rs = stmt.executeQuery(readByIDStmt);
			ArrayList<Customer> customerList = new ArrayList<>();
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("address"), rs.getString("phone"));
				customerList.add(customer);
			}
			
			System.out.println(customerList);

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void readCust() {
		printCustData("SELECT * FROM customer;");
	}
	@Override
	public void readProd() {
		printProdData("SELECT * FROM product;");
	}
	@Override
	public void readCustById(Customer c) {
		printCustData("SELECT * FROM customer where id = " + c.getId() + ";");
	}
	@Override
	public void readProdById(Product p) {
		printProdData("SELECT * FROM product where id = " + p.getId() + ";");
	}
	@Override
	public void readCustByName(Customer c) {
		printCustData("SELECT * FROM customer where first_name = '" + c.getFirstName() + "';");
	}
	@Override
	public void readProdByCat(Product p) {
		printProdData("SELECT * FROM product where category = '" + p.getCategory() + "';");
	}
	
	
	@Override
	public void update(Customer c, String updateVal) {
		updateData("UPDATE customer SET first_name = '" + updateVal + "' WHERE id = " + c.getId() + ";", "Update");
	}
	@Override
	public void update(Product p, String updateVal) {
		updateData("UPDATE product SET name = '" + updateVal + "' WHERE id = " + p.getId() + ";", "Update");
	}
	
	
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
		updateData("ALTER TABLE " + tableName + " AUTO_INCREMENT=1;", "Reset ID");
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
