package com.bmarques.supplier.api.product;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private String state;
    private String description;
    private BigDecimal price;
}
