package com.qa.IMS;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	
	public String getMenuOption() {
		System.out.println("\nEnter [1] for access to Customer records \nOR\nEnter [2] for access to Product records");
		return sc.nextLine();
	}
	
	
	public void displayMenu() {

			String menuOption = getMenuOption();
			
			switch (menuOption) {
			case "1":
				CustomerChoice startCust = new CustomerChoice();
				startCust.options();
				break;
			case "2":
				ProductChoice startAlt = new ProductChoice();
				startAlt.options();
				break;
			default:
				System.out.println("Invalid CRUD choice");	
				
			}
			
	}
	
}
