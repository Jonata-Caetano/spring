package com.tr.bluemoon.springunittestmock.repository;

import com.tr.bluemoon.springunittestmock.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
