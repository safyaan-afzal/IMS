//package com.qa.CRUDqueries;
//
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.qa.CRUDqueries.CRUDqueries;
//import com.qa.Customer.Customer;
//import com.qaProduct.Product;
//
//public class CRUDqueriesTest {
//	
//	CRUDqueries query = new CRUDqueries();
//	CRUDqueries q;
//	
//	Customer cust = new Customer();
// 	Customer c;
// 	
// 	Product prod = new Product();
//	Product p;
//	
//    @BeforeAll
//    public static void start() {
//        System.out.println("BeforeAll: Start of TestSuite\n");
//       
//    }
//    
//    @BeforeEach
//	//initialise test data
//	public void setUp() {
//    	c = new Customer("Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700 900077");
//		c = new Customer(10, "Joe", "Bloggs", "joe@gmail.com", "London", "+44 7700900077");
//		cust.setId(1);
//		cust.setFirstName("John");
//		cust.setLastName("Nobody");
//		cust.setEmail("John@gmail.com");
//		cust.setAddress("Leeds");
//		cust.setPhone("+44 7782375950");
//		
//    	p = new Product(10, "Snickers", "Chocloate", new BigDecimal(0.75));
//		p = new Product("Snickers", "Chocloate", new BigDecimal(0.75));
//		prod.setId(1);
//		prod.setName("Bounty");;
//		prod.setCategory("Chocolate");
//		prod.setPrice(new BigDecimal (0.50));	
//	}
//  
//    
//    
//    @Test
//    public void testCreateCustomer() {
//        Assertions.assertEquals(c, query.create(c));
//        
//    }
//    
//    @Test
//    public void testCreateProduct() {
//    	Assertions.assertEquals(p, query.create(p));
//        
//    }
//    
//    @Test
//	public void testReadCustById() {
//		Assertions.assertEquals(c, query.readCustById(c));
//	}
//    @Test
//	public void testReadProdById() {
//    	Assertions.assertEquals(p, query.readProdById(p));
//	}
//    @Test
//	public void testReadCustByName() {
//    	Assertions.assertEquals(c, query.readCustByName(c));
//	}
//    @Test
//	public void readProdByCat() {
//    	Assertions.assertEquals(p, query.readProdByCat(p));
//	}
//    
//    @Test
//    public void testUpdateCustomer() {
//        Assertions.assertEquals(c, query.update(c, "Steve"));
//        
//        
//    }
//    
//    @Test
//    public void testUpdateProduct() {
//    	Assertions.assertEquals(p, query.update(p, "Galaxy"));
//        
//    }
//    
//    
//    @Test
//    public void testDeleteCustomer() {
//    	Assertions.assertEquals(c, query.delete(c));
//        
//    }
//    
//    @Test
//    public void testDeleteProduct() {
//    	Assertions.assertEquals(p, query.delete(p));
//        
//    }
//    
//    
//
//    
//    
//    
//    
//    
//	
//	
//}
