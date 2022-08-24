package com.qa.Customer;

import java.util.Objects;

public class Customer {

	// Encapsulation

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String phone;


	public Customer() {
		super();
	}
	
	
	public Customer(int id, String firstName, String lastName, String email, String address, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Customer(String firstName, String lastName, String email, String address, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
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


	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstName, id, lastName, phone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone);
	}
	
	

	
	

}
