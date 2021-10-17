package com.example.springcassandra;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")
public class Product {

    @Id
    private String productId;
}