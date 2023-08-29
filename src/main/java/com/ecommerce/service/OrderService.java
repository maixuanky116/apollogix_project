package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.OrderException;
import com.ecommerce.model.Orders;

public interface OrderService {

	public Orders addOrder(int cid) throws OrderException, CustomerException, CartException;

	public Orders updateOrder(Orders order) throws OrderException;

	public Orders viewOrder(int orderId) throws OrderException;

	public List<Orders> viewAllOrder() throws OrderException;

	public List<Orders> viewAllOrdersByUserId(int userId) throws OrderException;

}
