package com.bmarques.springarchunitmvcexample.repository;

import com.bmarques.springarchunitmvcexample.domain.invoice.Invoice;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class InvoiceRepository {

    public Invoice getInvoice() {
        return Invoice.builder()
                .id(1)
                .installment(LocalDate.now())
                .value(5D)
                .build();
    }
}
