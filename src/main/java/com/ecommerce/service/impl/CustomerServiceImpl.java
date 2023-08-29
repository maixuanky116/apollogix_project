package com.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.repository.CartRepo;
import com.ecommerce.repository.CustomerRepo;
import com.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;

	@Autowired
	CartRepo cartRepo;

	@Override
	public Customer addCustomer(final Customer customer) throws CustomerException {
		Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		return cRepo.save(customer);
    }

	@Override
	public Customer updateCustomer(final Customer customer) throws CustomerException {
		final Customer c = cRepo.findById(customer.getCId()).orElseThrow(() -> new CustomerException("Customer not found"));
		if (c != null) {
			cRepo.save(customer);
		}
		return c;
	}

	@Override
	public Customer remove(final int customerId) throws CustomerException {
		final Optional<Customer> opt = cRepo.findById(customerId);
		if (opt.isPresent()) {
			Customer c = opt.get();
			cRepo.delete(c);
			return c;
		} else {
			throw new CustomerException("Customer not found with cid - " + customerId);
		}

	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		final List<Customer> customers = cRepo.findAll();
		if (!customers.isEmpty()) {
			return customers;
		} else {
			throw new CustomerException("customer not found");
		}
	}

}
