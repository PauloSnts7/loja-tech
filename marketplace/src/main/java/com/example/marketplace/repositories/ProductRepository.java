package com.example.marketplace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.marketplace.entities.Product;
import com.example.marketplace.entities.User;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findBySeller(User seller);
	

}
