package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public Customer remove(int customerId) throws CustomerException;

	public List<Customer> viewAllCustomer() throws CustomerException;

}
