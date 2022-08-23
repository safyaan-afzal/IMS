package com.qa.IMS;

import java.util.Scanner;

public class Choice {

	private static Scanner sc = new Scanner(System.in);
	Customer cust = new Customer();

	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}
	
	public void createCustomer(CRUDqueries q) {
		System.out.println("Enter first name: ");
		String fName = sc.nextLine();
		cust.setFirstName(fName);
		System.out.println("Enter last name: ");
		String lName = sc.nextLine();
		cust.setLastName(lName);
		System.out.println("Enter address: ");
		String address = sc.nextLine();
		cust.setAddress(address);
		System.out.println("Enter email: ");
		String email = sc.nextLine();
		cust.setEmail(email);
		System.out.println("Enter phone: ");
		String phone = sc.nextLine();
		cust.setPhone(phone);
		q.create(cust);
		
	}
	
	public void readCustomer(CRUDqueries q) {
		System.out.println("1. Read all\n2. Read by id\n3. Read by name");
		String readChoice = sc.nextLine();
		if (readChoice.toLowerCase().equals("1")) {
			q.read();
		} else if (readChoice.toLowerCase().equals("2")) {
			System.out.println("Enter ID: ");
			int rID = sc.nextInt();
			cust.setId(rID);
			sc.nextLine();
			q.readById(cust);
		} else if (readChoice.toLowerCase().equals("3")) {
			System.out.println("Enter Name: ");
			String rName = sc.nextLine();
			cust.setFirstName(rName);
			q.readByName(cust);
			
		} else {
			System.out.println("Invalid Entry");
		}	
		
	}
	
	public void updateCustomer(CRUDqueries q) {
		System.out.println("Enter id of record to update: ");
		int uID = sc.nextInt();
		cust.setId(uID);
		sc.nextLine();//capture enter key
		System.out.println("Enter the new first name of the customer: ");
		String uName = sc.nextLine();
		q.update(cust, uName);	
		
	}
	
	public void deleteCustomer(CRUDqueries q) {
		System.out.println("Enter id of record to delete: ");
		int dID = sc.nextInt();
		sc.nextLine();//capture enter key
		cust.setId(dID);
		q.delete(cust);
		
	}
	
	
	public void options() {
		// create an instance of the CRUD queries class to open the connection
		CRUDqueries q = new CRUDqueries();
		
		String crud = getInput();

		// try-finally block so the finally block can close the connection
		try {
			// do-while loop to start the loop and present the options to interact with the
			// database
			do {
				switch (crud.toLowerCase()) {
				case "create":
					createCustomer(q);
					break;
				case "read":
					readCustomer(q);
					break;
				case "update":
					updateCustomer(q);
					break;
				case "delete":
					deleteCustomer(q);
					break;
				default:
					System.out.println("Invalid CRUD choice");
				}
				// check if user wants to continue or break out of the loop
				System.out.println("\nWould you like to continue? (y/n)");
				String quit = sc.nextLine();
				if (quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if (quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}

			} while (!crud.equals("quit"));
			System.out.println("Goodbye!");
		} finally {
			q.closeConn();
		}

	}

}
