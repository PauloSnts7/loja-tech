package com.example.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.example.marketplace.entities.Product;
import com.example.marketplace.entities.User;
import com.example.marketplace.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> product = productService.getAllProducts();
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/{sellerId}")
	public ResponseEntity<List<Product>> getProductsByseller(@PathVariable 
			Long sellerId) {
		User seller = new User();
		seller.setId(sellerId);
		List<Product> products = productService.getProductBySeller(seller);
		return ResponseEntity.ok(products);
		
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product newProduct = productService.saveProduct(product);
		return ResponseEntity.ok(newProduct);
	}
	
}
