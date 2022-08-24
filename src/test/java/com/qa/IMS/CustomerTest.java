package com.qa.IMS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	
	Customer cust = new Customer();
	Customer c;
	
    @BeforeAll
    public static void start() {
        System.out.println("BeforeAll: Start of TestSuite\n");
    }
    
	@BeforeEach //JUNIT4 - Before
	//initialise test data
	public void setUp() {
		c = new Customer("Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700 900077");
		c = new Customer(10, "Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700900077");
		cust.setId(1);
		cust.setFirstName("John");
		cust.setLastName("Nobody");
		cust.setEmail("John@gmail.com");
		cust.setAddress("Leeds");
		cust.setPhone("+44 7782375950");	
	}
	
    @Test
    public void testGetId(){
    	Assertions.assertEquals(1, cust.getId());
    }

    @Test
    public void testGetFirstName(){
    	Assertions.assertEquals("John", cust.getFirstName());
    }
    
    @Test
    public void testGetLastName(){
    	Assertions.assertEquals("Nobody", cust.getLastName());
    }
    
    @Test
    public void testGetEmail(){
    	Assertions.assertEquals("John@gmail.com", cust.getEmail());
    }
    
    @Test
    public void testGetAddress(){
    	Assertions.assertEquals("Leeds", cust.getAddress());
    }
    
    @Test
    public void testGetPhone(){
    	Assertions.assertEquals("+44 7782375950", cust.getPhone());
    }
    
    
    

	
	
	

}
