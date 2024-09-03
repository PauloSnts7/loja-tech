package com.example.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.marketplace.entities.Order;
import com.example.marketplace.entities.User;
import com.example.marketplace.repositories.OrderRepository;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getOrdersByBuyer(User buyer) {
		return orderRepository.findBybuyer(buyer);
		
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

}
