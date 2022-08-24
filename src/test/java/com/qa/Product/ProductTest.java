//package com.qa.Product;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.qaProduct.Product;
//
//public class ProductTest {
//	
//	Product prod = new Product();
//	Product p;
//	
//    @BeforeAll
//    public static void start() {
//        System.out.println("BeforeAll: Start of TestSuite\n");
//    }
//    
//	@BeforeEach //JUNIT4 - Before
//	//initialise test data
//	public void setUp() {
//		p = new Product(10, "Snickers", "Chocloate", new BigDecimal(0.75));
//		p = new Product("Snickers", "Chocloate", new BigDecimal(0.75));
//		prod.setId(1);
//		prod.setName("Bounty");;
//		prod.setCategory("Chocolate");
//		prod.setPrice(new BigDecimal (0.50));
//	}
//	
//    @Test
//    public void testGetId(){
//    	Assertions.assertEquals(1, prod.getId());
//    }
//    
//    @Test
//    public void testGetName(){
//    	Assertions.assertEquals("Bounty", prod.getName());
//    }
//    
//    @Test
//    public void testGetCategory(){
//    	Assertions.assertEquals("Chocolate", prod.getCategory());
//    }
//    
//    @Test
//    public void testGetPrice(){
//    	Assertions.assertEquals(new BigDecimal(0.50), prod.getPrice());
//    }
//
//
//}
