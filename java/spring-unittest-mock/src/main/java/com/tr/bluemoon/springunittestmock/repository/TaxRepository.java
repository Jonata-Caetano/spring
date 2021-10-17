package com.tr.bluemoon.springunittestmock.repository;

import com.tr.bluemoon.springunittestmock.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Integer> {
}
