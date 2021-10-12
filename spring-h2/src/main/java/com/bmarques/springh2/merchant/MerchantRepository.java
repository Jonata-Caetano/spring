package com.bmarques.springh2.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Integer> {
}
