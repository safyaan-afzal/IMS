package com.qa.Customer;

import java.util.Scanner;

import com.qa.CRUDqueries.CRUDqueries;
import com.qa.IMS.ParentChoice;

public class CustomerChoice extends ParentChoice {

	private static Scanner sc = new Scanner(System.in);
	Customer cust = new Customer();
	
	@Override
	public void create(CRUDqueries q) {
		String fName = getInput("first name");
		cust.setFirstName(fName);
		String lName = getInput("last name");
		cust.setLastName(lName);
		String email = getInput("email");
		cust.setEmail(email);
		String address = getInput("address");
		cust.setAddress(address);
		String phone = getInput("phone");
		cust.setPhone(phone);
		q.create(cust);
		
	}
	
	@Override
	public void read(CRUDqueries q) {
		String readChoice = getInput("\n1. Read all\n2. Read by id\n3. Read by name");
		if (readChoice.toLowerCase().equals("1")) {
			q.readCust();
		} else if (readChoice.toLowerCase().equals("2")) {
			int rID = Integer.parseInt(getInput("ID"));
			cust.setId(rID);
			q.readCustById(cust);
		} else if (readChoice.toLowerCase().equals("3")) {
			String rName = getInput("name");
			cust.setFirstName(rName);
			q.readCustByName(cust);
			
		} else {
			System.out.println("Invalid Entry");
		}	
		
	}
	
	@Override
	public void update(CRUDqueries q) {
		int uID = Integer.parseInt(getInput("id of record to update"));
		cust.setId(uID);
		String uName = getInput("the new first name of the customer");
		q.update(cust, uName);	
	}

	@Override
	public void delete(CRUDqueries q) {
		int dID = Integer.parseInt(getInput("id of record to delete"));
		cust.setId(dID);
		q.delete(cust);
	}
	

}
