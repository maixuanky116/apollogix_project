package com.ecommerce.service;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;

import java.util.List;

public interface ProductService {

	public List<Product> viewAllProduct() throws ProductException;

	public Product addProduct(Product product) throws ProductException;

	public Product updateProduct(Product product) throws ProductException;

	public Product viewProduct(int productId) throws ProductException;

	public List<Product> viewProductByNameAndCategory(String productName, int categoryId) throws ProductException;
}
