package com.ecommerce.controller;

import com.ecommerce.exception.AddressException;
import com.ecommerce.model.Address;
import com.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/view")
	public ResponseEntity<List<Address>> viewAllAddress()
			throws AddressException {
		return new ResponseEntity<List<Address>>(addressService.viewAllAddress(), HttpStatus.OK);
	}

}
