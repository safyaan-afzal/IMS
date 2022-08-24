package com.qa.IMS;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CRUDqueriesTest {
	
	CRUDqueries query = new CRUDqueries();
	CRUDqueries q;
	
	Customer cust = new Customer();
 	Customer c;
 	
 	Product prod = new Product();
	Product p;
	
    @BeforeAll
    public static void start() {
        System.out.println("BeforeAll: Start of TestSuite\n");
       
    }
    
    @BeforeEach
	//initialise test data
	public void setUpCustomer() {
    	c = new Customer("Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700 900077");
		c = new Customer(10, "Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700900077");
		cust.setId(1);
		cust.setFirstName("John");
		cust.setLastName("Nobody");
		cust.setEmail("John@gmail.com");
		cust.setAddress("Leeds");
		cust.setPhone("+44 7782375950");	
	}
    
    @BeforeEach
 	//initialise test data
 	public void setUpProduct() {
    	p = new Product(10, "Snickers", "Chocloate", new BigDecimal(0.75));
		p = new Product("Snickers", "Chocloate", new BigDecimal(0.75));
		prod.setId(1);
		prod.setName("Bounty");;
		prod.setCategory("Chocolate");
		prod.setPrice(new BigDecimal (0.50));	
 	}
    
    
    @Test
    public void testCreateCustomer() {
        query.create(c);
        
    }
    
    @Test
    public void testCreateProduct() {
        query.create(p);
        
    }
    
    @Test
	public void testReadCustById() {
		query.readCustById(c);
	}
    @Test
	public void testReadProdById() {
    	query.readProdById(p);
	}
    @Test
	public void testReadCustByName() {
    	query.readCustByName(c);
	}
    @Test
	public void readProdByCat() {
    	query.readProdByCat(p);
	}
    
    @Test
    public void testUpdateCustomer() {
        query.update(c, "Steve");
        
    }
    
    @Test
    public void testUpdateProduct() {
        query.update(p, "Galaxy");
        
    }
    
    
    @Test
    public void testDeleteCustomer() {
        query.delete(c);
        
    }
    
    @Test
    public void testDeleteProduct() {
        query.delete(p);
        
    }
    
    

    
    
    
    
    
	
	
}
