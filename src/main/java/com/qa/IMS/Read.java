package com.qa.IMS;

public interface Read {
	
	public void readCust();
	public void readProd();
	
	public void readCustById(Customer c);
	public void readProdById(Product p);
	
	public void readCustByName(Customer c);
	public void readProdByCat(Product p);

}
