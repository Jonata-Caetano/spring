package com.example.springcassandra.controller;

import com.example.springcassandra.Product;
import com.example.springcassandra.ProductReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

    @Autowired
    private ProductReactiveRepository productReactiveRepository;

    @GetMapping("/products")
    public Flux getProducts() {
        return productReactiveRepository.findAll();
    }

    @PostMapping("/products/save")
    public Mono createProductUsingSaveAPI(@RequestBody Product product) {
        return productReactiveRepository.save(product);
    }
}