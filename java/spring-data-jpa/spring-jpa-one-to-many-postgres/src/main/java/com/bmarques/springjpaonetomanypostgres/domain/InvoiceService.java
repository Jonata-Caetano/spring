package com.bmarques.springjpaonetomanypostgres.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;


    public InvoiceEntity save(InvoiceEntity invoiceEntity) {
        return repository.save(invoiceEntity);
    }
}
