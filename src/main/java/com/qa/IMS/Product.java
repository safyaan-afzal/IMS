package com.qa.IMS;

import java.math.BigDecimal;

public class Product {
	
	// Encapsulation

	private int id;
	private String name;
	private String category;
	private BigDecimal price;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String category, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Product(String name, String category, BigDecimal price) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
	
	
	

}
