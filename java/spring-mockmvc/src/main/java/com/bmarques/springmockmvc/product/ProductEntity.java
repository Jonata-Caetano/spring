package com.bmarques.springmockmvc.product;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductEntity {

    private Long id;
    private String name;
    private Double price;
}
