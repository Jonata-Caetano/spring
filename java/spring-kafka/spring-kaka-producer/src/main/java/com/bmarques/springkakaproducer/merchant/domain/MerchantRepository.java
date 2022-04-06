package com.bmarques.springkakaproducer.merchant.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, UUID> {
}
