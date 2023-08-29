package com.ecommerce.controller;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.ProductCustomer;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cService;

	@PostMapping("/add")
	public ResponseEntity<Cart> addProductToCart(@RequestBody final ProductCustomer productCustomer)
			throws CartException, CustomerException, ProductException {
		return new ResponseEntity<Cart>(cService.addProductToCart(productCustomer.getCustomerId(),
				productCustomer.getProductId()), HttpStatus.OK);

	}
}
