package com.example.marketplace.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.marketplace.entities.Order;
import com.example.marketplace.entities.User;
import com.example.marketplace.services.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://127.0.0.1:5500/index.html")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Para obter pedidos por buyerId
    @GetMapping("/{buyerId}")
    public ResponseEntity<List<Order>> getOrdersByBuyer(@PathVariable Long buyerId) {
        User buyer = new User();
        buyer.setId(buyerId);
        List<Order> orders = orderService.getOrdersByBuyer(buyer);
        return ResponseEntity.ok(orders);
    }

    // Para lidar com GET sem buyerId
    @GetMapping
    public ResponseEntity<String> handleGetWithoutBuyerId() {
        return ResponseEntity.status(405).body("GET method not allowed without buyerId");
    }

    // Para adicionar um novo pedido
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order newOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(newOrder);
    }
}

