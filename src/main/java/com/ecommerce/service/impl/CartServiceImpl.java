package com.ecommerce.service.impl;

import com.ecommerce.exception.CartException;
import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartRepo;
import com.ecommerce.repository.CustomerRepo;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cRepo;

	@Autowired
	private CustomerRepo crRepo;

	@Autowired
	private ProductRepo pRepo;

	@Override
	public Cart addProductToCart(final int customerId, final int productId)
			throws CartException, CustomerException, ProductException {
		final Optional<Customer> opt = crRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		final Optional<Product> itemOpt = pRepo.findById(productId);
		if (itemOpt.isEmpty())
			throw new ProductException("Product not found!");

		final Customer customer = opt.get();
		final Cart cart = customer.getCart();

		final List<Product> itemList = cart.getProducts();
		boolean flag = true;
		for (int i = 0; i < itemList.size(); i++) {
			final Product element = itemList.get(i);
			if (element.getProductId() == productId) {
				if (cart.getProduct_quantity() == null) {
					cart.setProduct_quantity(1);

				} else {
					cart.setProduct_quantity(cart.getProduct_quantity() + 1);
				}

				flag = false;
			}
		}
		if (flag) {
			cart.getProducts().add(itemOpt.get());
		}

		cRepo.save(cart);
		return cart;

	}
}
