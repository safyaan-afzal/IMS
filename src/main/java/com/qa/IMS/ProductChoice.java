package com.qa.IMS;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductChoice extends ParentClass {
	
	private static Scanner sc = new Scanner(System.in);
	Product prod = new Product();

	@Override
	public void create(CRUDqueries q) {
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
		
	}

	@Override
	public void read(CRUDqueries q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CRUDqueries q) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CRUDqueries q) {
		// TODO Auto-generated method stub
		
	}
	

}
