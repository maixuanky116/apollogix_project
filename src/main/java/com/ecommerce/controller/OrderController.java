package com.ecommerce.controller;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Orders;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService oService;

	@PostMapping("/add")
	public ResponseEntity<Orders> addOrder(@RequestBody final Customer customer)
			throws OrderException, CustomerException, CartException {
		return new ResponseEntity<Orders>(oService.addOrder(customer.getCId()), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Orders> updateOrder(@RequestBody final Orders order) throws OrderException {
		return new ResponseEntity<Orders>(oService.updateOrder(order), HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Orders> viewOrderById(@PathVariable("id") final int orderId) throws OrderException {
		return new ResponseEntity<Orders>(oService.viewOrder(orderId), HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Orders>> viewAllOrder() throws OrderException {
		return new ResponseEntity<List<Orders>>(oService.viewAllOrder(), HttpStatus.OK);
	}

	@GetMapping("/view/{userId}")
	public ResponseEntity<List<Orders>> viewOrderByUserId(@PathVariable("userId") final int userId)
			throws OrderException {
		return new ResponseEntity<List<Orders>>(oService.viewAllOrdersByUserId(userId), HttpStatus.OK);
	}
}
