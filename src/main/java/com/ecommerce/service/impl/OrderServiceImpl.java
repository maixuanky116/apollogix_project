package com.ecommerce.service.impl;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.CustomerRepo;
import com.ecommerce.repository.OrderRepo;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo oRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Orders addOrder(final int cid) throws OrderException, CustomerException, CartException {

		final Customer customer = customerRepo.findById(cid).orElseThrow();
		final Cart cart = customer.getCart();
		if (cart.getProducts().isEmpty()) {
			throw new CartException("add minimum one product to order!");
		}

		final Orders o = new Orders();
		o.setDate(LocalDateTime.now());
		o.setOrderStatus("Pending");
		o.setAddress(customer.getAddress());
		o.setCustomer(customer);

		o.setProductList(new ArrayList<>(cart.getProducts()));
		return oRepo.save(o);
	}

	@Override
	public Orders updateOrder(final Orders order) throws OrderException {
		final Orders o = oRepo.findById(order.getOrderId()).orElseThrow(() -> new OrderException("Order not found"));
		if (o != null) {
			oRepo.save(order);
		}
		return o;
	}

	@Override
	public Orders viewOrder(final int orderId) throws OrderException {
		final Optional<Orders> o = oRepo.findById(orderId);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new OrderException("order not present!!");
		}
	}

	@Override
	public List<Orders> viewAllOrder() throws OrderException {
		final List<Orders> orders = oRepo.findAll();
		if (!orders.isEmpty()) {
			return orders;
		} else {
			throw new OrderException("Order not found");
		}
	}

	@Override
	public List<Orders> viewAllOrdersByUserId(final int userId) throws OrderException {
		final List<Orders> orders = customerRepo.getAllOrderByCid(userId);
		if (!orders.isEmpty()) {
			return orders;
		} else {
			throw new OrderException("Order not found");
		}
	}

}
