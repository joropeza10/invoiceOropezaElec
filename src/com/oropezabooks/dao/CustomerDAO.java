package com.oropezabooks.dao;

import java.util.List;

import com.oropezabooks.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer newCustomer);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	
}
