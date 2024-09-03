package com.example.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.marketplace.entities.User;
import com.example.marketplace.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new
				RuntimeException("User not found"));
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
