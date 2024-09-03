package com.example.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.marketplace.entities.User;
import com.example.marketplace.services.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User newUser = userService.saveUser(user);
		return ResponseEntity.ok(newUser);
		
	}
	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		User user = userService.findByUsername(username);
		return ResponseEntity.ok(user);
		}
}
