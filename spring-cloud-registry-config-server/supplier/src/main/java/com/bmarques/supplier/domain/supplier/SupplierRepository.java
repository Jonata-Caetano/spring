package com.bmarques.supplier.domain.supplier;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<SupplierEntity, Long> {
    SupplierEntity findByState(String state);
}
