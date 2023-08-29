package com.ecommerce.service.impl;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CategoryRepo;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo pRepo;

	@Autowired
	private CategoryRepo cRepo;

	@Override
	public List<Product> viewAllProduct() throws ProductException {
		final List<Product> products = pRepo.findAll();
		if (!products.isEmpty()) {
			return products;
		} else {
			throw new ProductException("Products not found");
		}
	}

	@Override
	public Product addProduct(final Product product) throws ProductException {
		return pRepo.save(product);
    }

	@Override
	public Product updateProduct(final Product product) throws ProductException {
		final Optional<Product> opt = pRepo.findById(product.getProductId());
		if (opt.isPresent()) {
			return pRepo.save(product);
		} else {
			throw new ProductException("Product not updated");
		}
	}

	@Override
	public Product viewProduct(final int productId) throws ProductException {
		final Optional<Product> opt = pRepo.findById(productId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new ProductException("Product not found with product id - " + productId);
		}
	}

	@Override
	public List<Product> viewProductByNameAndCategory(final String productName, final int categoryId) throws ProductException {
		final Optional<Category> category = cRepo.findById(categoryId);
		if (category.isPresent()) {
			return category.get().getProductList().stream()
					.filter(product -> product.getProductName().equals(productName))
					.collect(Collectors.toList());
		} else {
			throw new ProductException("Product not found with product name and category id");
		}

	}

}
