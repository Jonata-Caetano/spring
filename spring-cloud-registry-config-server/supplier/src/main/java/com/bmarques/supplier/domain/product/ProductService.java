package com.bmarques.supplier.domain.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> getProductsByState(String state) {
        return repository.findByState(state);
    }
}
