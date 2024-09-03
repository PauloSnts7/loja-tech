package com.example.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.marketplace.entities.Product;
import com.example.marketplace.entities.User;
import com.example.marketplace.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		
	}
	
	public List<Product> getProductBySeller(User seller) {
		return productRepository.findBySeller(seller);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	
	
	
}
