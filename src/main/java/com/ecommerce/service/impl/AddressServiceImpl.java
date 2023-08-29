package com.ecommerce.service.impl;

import com.ecommerce.exception.AddressException;
import com.ecommerce.model.Address;
import com.ecommerce.repository.AddressRepo;
import com.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public List<Address> viewAllAddress() throws AddressException {

		final List<Address> addresses = addressRepo.findAll();
		if (addresses.isEmpty())
			throw new AddressException("Address list is empty!");
		return addresses;
	}

}
