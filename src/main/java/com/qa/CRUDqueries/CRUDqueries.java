package com.qa.CRUDqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.qa.Customer.Customer;
import com.qaProduct.Product;

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
	public Customer create(Customer c) {

			updateData("INSERT INTO customer(first_name, last_name, address, email, phone) VALUES('" + c.getFirstName() + "','" + c.getLastName()
					+ "','" + c.getEmail() + "','" + c.getAddress() + "','" + c.getPhone() + "');", "create");
			
			return c;
		}
	
	@Override
	public Product create(Product p) {
		
		updateData("INSERT INTO product(name, category, price) VALUES('" + p.getName() + "','" + p.getCategory()
		+ "'," + p.getPrice() + ");", "create");
		return p;
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
	public Customer readCustById(Customer c) {
		printCustData("SELECT * FROM customer where id = " + c.getId() + ";");
		return c;
	}
	@Override
	public Product readProdById(Product p) {
		printProdData("SELECT * FROM product where id = " + p.getId() + ";");
		return p;
	}
	@Override
	public Customer readCustByName(Customer c) {
		printCustData("SELECT * FROM customer where first_name = '" + c.getFirstName() + "';");
		return c;
	}
	@Override
	public Product readProdByCat(Product p) {
		printProdData("SELECT * FROM product where category = '" + p.getCategory() + "';");
		return p;
	}
	
	
	@Override
	public Customer update(Customer c, String updateVal) {
		updateData("UPDATE customer SET first_name = '" + updateVal + "' WHERE id = " + c.getId() + ";", "Update");
		return c;
	}
	@Override
	public Product update(Product p, String updateVal) {
		updateData("UPDATE product SET name = '" + updateVal + "' WHERE id = " + p.getId() + ";", "Update");
		return p;
	}
	
	
	@Override
	public Customer delete(Customer c) {
		updateData("DELETE FROM customer WHERE id=" + c.getId() + ";", "Delete");
		autoInc("customer");
		return c;
	}
	@Override
	public Product delete(Product p) {
		updateData("DELETE FROM product WHERE id=" + p.getId() + ";", "Delete");
		autoInc("product");
		return p;
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
