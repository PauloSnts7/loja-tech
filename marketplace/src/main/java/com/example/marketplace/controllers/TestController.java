package com.example.marketplace.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("O Spring Boot está funcionando!");
    }
}
