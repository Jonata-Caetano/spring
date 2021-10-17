package com.bmarques.springmockmvc.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<ProductEntity> productEntities = new ArrayList<>();;

    public List<ProductEntity> getAllProducts() {
        return productEntities;
    }

    public ProductEntity save(ProductEntity productEntity) {
        productEntities.add(productEntity);
        return productEntity;
    }

    public ProductEntity getProductById(Long id) {
        return productEntities.stream()
                .filter(productEntity -> productEntity.getId().equals(id))
                .findFirst()
                .get();
    }
}
