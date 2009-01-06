package org.kirhgoff.mysha.server.dao;

import java.util.List;

import org.kirhgoff.mysha.domain.Customer;

public interface CustomerDAO {

	public static final String NAME = "customerDAO";

	List<Customer> getAllCustomers ();
	int countAll ();
	Customer saveCustomer(Customer customer);
}