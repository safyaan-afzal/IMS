package com.qa.IMS;

public abstract class ParentClass {
	
	
	public abstract void create(CRUDqueries q);
	
	public abstract void read(CRUDqueries q);
	
	public abstract void update(CRUDqueries q);
	
	public abstract void delete(CRUDqueries q);
	
	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
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
					create(q);
					break;
				case "read":
					read(q);
					break;
				case "update":
					update(q);
					break;
				case "delete":
					delete(q);
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
