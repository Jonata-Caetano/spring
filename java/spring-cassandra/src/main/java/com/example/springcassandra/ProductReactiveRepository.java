package com.example.springcassandra;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ProductReactiveRepository extends ReactiveCassandraRepository<Product, String> {

}
