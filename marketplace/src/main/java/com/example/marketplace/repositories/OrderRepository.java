package com.example.marketplace.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.marketplace.entities.Order;
import com.example.marketplace.entities.User;


public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findBybuyer(User buyer);

}
