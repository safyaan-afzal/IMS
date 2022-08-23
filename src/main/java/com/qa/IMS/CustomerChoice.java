package com.qa.IMS;

import java.util.Scanner;

public class CustomerChoice extends ParentClass {

	private static Scanner sc = new Scanner(System.in);
	Customer cust = new Customer();
	
	@Override
	public void create(CRUDqueries q) {
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
	
	@Override
	public void read(CRUDqueries q) {
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
	
	@Override
	public void update(CRUDqueries q) {
		System.out.println("Enter id of record to update: ");
		int uID = sc.nextInt();
		cust.setId(uID);
		sc.nextLine();//capture enter key
		System.out.println("Enter the new first name of the customer: ");
		String uName = sc.nextLine();
		q.update(cust, uName);	
		
	}

	@Override
	public void delete(CRUDqueries q) {
		System.out.println("Enter id of record to delete: ");
		int dID = sc.nextInt();
		sc.nextLine();//capture enter key
		cust.setId(dID);
		q.delete(cust);
		
	}
	

}
