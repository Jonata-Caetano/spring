package com.bmarques.springjpaonetomanyoracle.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
