package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/view")
	public ResponseEntity<List<Product>> viewAllProduct() throws ProductException {
		return new ResponseEntity<List<Product>>(pService.viewAllProduct(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody final Product p) throws ProductException {
		Product product = pService.addProduct(p);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody final Product p) throws ProductException {
		Product product = pService.updateProduct(p);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("paging/search/filter/{productId}")
	public ResponseEntity<Product> viewProductById(@PathVariable("productId") final int productId) throws ProductException {
		return new ResponseEntity<Product>(pService.viewProduct(productId), HttpStatus.OK);
	}

	@GetMapping("paging/search/filter")
	public ResponseEntity<List<Product>> viewProductByCategoryId(@RequestParam("productName") final String productName,
																 @RequestParam("categoryId") final int categoryId) throws ProductException {
		return new ResponseEntity<List<Product>>(pService.viewProductByNameAndCategory(productName, categoryId), HttpStatus.OK);
	}

}
