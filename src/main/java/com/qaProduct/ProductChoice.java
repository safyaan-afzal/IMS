package com.qaProduct;

import java.math.BigDecimal;

import com.qa.CRUDqueries.CRUDqueries;
import com.qa.IMS.ParentChoice;

public class ProductChoice extends ParentChoice {
	
	Product prod = new Product();

	@Override
	public void create(CRUDqueries q) {
		String pName = getInput("name");
		prod.setName(pName);
		String cat = getInput("category");
		prod.setCategory(cat);
		BigDecimal price = new BigDecimal(getInput("price"));
		prod.setPrice(price);
		q.create(prod);
		
	}

	@Override
	public void read(CRUDqueries q) {
		String readChoice = getInput("\n1. Read all\n2. Read by id\n3. Read by category");
		if (readChoice.toLowerCase().equals("1")) {
			q.readProd();
		} else if (readChoice.toLowerCase().equals("2")) {
			int rID = Integer.parseInt(getInput("ID"));
			prod.setId(rID);
			q.readProdById(prod);
		} else if (readChoice.toLowerCase().equals("3")) {
			String rCat = getInput("category");
			prod.setCategory(rCat);
			q.readProdByCat(prod);
		} else {
			System.out.println("Invalid Entry");
		}
	}

	@Override
	public void update(CRUDqueries q) {
		int uID = Integer.parseInt(getInput("id of record to update"));
		prod.setId(uID);
		String uName = getInput("the new name of the product");
		q.update(prod, uName);	
	}

	@Override
	public void delete(CRUDqueries q) {
		int dID = Integer.parseInt(getInput("ID of record to delete"));
		prod.setId(dID);
		q.delete(prod);
		
	}
	

}
