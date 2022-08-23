package com.qa.IMS;

import java.math.BigDecimal;
import java.util.Scanner;

public class ChoiceProducts {
	
	private static Scanner sc = new Scanner(System.in);
	Product prod = new Product();

	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}
	
	public void options() {
		// create an instance of the CRUD queries class to open the connection
		CRUDqueries q = new CRUDqueries();
		
		// Ask for user input on the CRUD choice in the getInput method and store the
		// result in the crud variable
		String crud = getInput();

		// try-finally block so the finally block can close the connection
		try {
			// do-while loop to start the loop and present the options to interact with the
			// database
			do {
				// switch case to match which CRUD operation to perform
				switch (crud.toLowerCase()) {
				case "create":
					System.out.println("Enter name: ");
					String pName = sc.nextLine();
					prod.setName(pName);
					System.out.println("Enter category: ");
					String cat = sc.nextLine();
					prod.setCategory(cat);;
					System.out.println("Enter price: ");
					BigDecimal price = sc.nextBigDecimal();
					sc.nextLine();
					prod.setPrice(price);
					q.create(prod);
					break;
				default:
					System.out.println("Invalid CRUD choice");
				}
				// check if user wants to continue or break out of the loop
				System.out.println("Would you like to continue? (y/n)");
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
