package com.bmarques.supplier.domain.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findByState(String state);

    List<ProductEntity> findByIdIn(List<Long> ids);
}
