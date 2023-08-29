
package com.ecommerce.service;

import com.ecommerce.exception.AddressException;
import com.ecommerce.model.Address;

import java.util.List;

public interface AddressService {

	public List<Address> viewAllAddress() throws AddressException;

}
