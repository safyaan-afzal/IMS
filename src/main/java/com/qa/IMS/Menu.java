package com.qa.IMS;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	
	public String getMenuInput() {
		System.out.println("\nEnter [1] for access to Customer records \nOR\nEnter [2] for access to Product records");
		return sc.nextLine();
	}
	
	
	public void displayMenu() {

			String menuOption = getMenuInput();
			
			switch (menuOption) {
			case "1":
				Choice start = new Choice();
				start.options();
				break;
			case "2":
				ChoiceProducts startAlt = new ChoiceProducts();
				startAlt.options();
				break;
			default:
				System.out.println("Invalid CRUD choice");	
				
			}
			
	}
	
}
