package com.qa.IMS;

public class Customer {

	// Encapsulation

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	
	
	public Customer() {
		super();
	}


	public Customer(int id, String firstName, String lastName, String address, String email, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}


	public Customer(String firstName, String lastName, String address, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Customer [ID = " + id + ", First Name = " + firstName + ", Last Name = " + lastName + ", Address = " + address
				+ ", Email = " + email + ", Phone = " + phone + "]";
	}
	
	

	
	

}
