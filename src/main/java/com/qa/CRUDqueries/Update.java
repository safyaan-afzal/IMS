package com.qa.CRUDqueries;

import com.qa.Customer.Customer;
import com.qaProduct.Product;

public interface Update {
	
	public Customer update(Customer c, String updateVal);
	public Product update(Product p, String updateVal);

}
