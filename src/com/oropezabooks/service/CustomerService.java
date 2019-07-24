package com.oropezabooks.service;

import java.util.List;

import com.oropezabooks.entity.Customer;

public interface CustomerService {

		public List<Customer> getCustomers();

		public void saveCustomer(Customer newCostumer);

		public Customer getCustomer(int customerId);

		public void deleteCustomer(int customerId);
}
