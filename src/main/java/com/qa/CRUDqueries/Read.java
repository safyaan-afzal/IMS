package com.qa.CRUDqueries;

import com.qa.Customer.Customer;
import com.qaProduct.Product;

public interface Read {
	
	public void readCust();
	public void readProd();
	
	public Customer readCustById(Customer c);
	public Product readProdById(Product p);
	
	public Customer readCustByName(Customer c);
	public Product readProdByCat(Product p);

}
