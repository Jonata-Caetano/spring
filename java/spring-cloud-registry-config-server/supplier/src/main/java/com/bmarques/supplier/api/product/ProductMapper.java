package com.bmarques.supplier.api.product;

import com.bmarques.supplier.domain.product.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .state(productEntity.getState())
                .description(productEntity.getDescription())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();

    }
}
