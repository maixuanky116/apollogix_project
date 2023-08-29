package com.ecommerce.service;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;

public interface CartService {

	public Cart addProductToCart(int customerId, int productId)
			throws CartException, CustomerException, ProductException;
}
