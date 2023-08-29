package com.ecommerce.model;

import lombok.Data;

@Data
public class ProductCustomer {

	private int customerId;
	private int productId;
	private int cartId;
}
