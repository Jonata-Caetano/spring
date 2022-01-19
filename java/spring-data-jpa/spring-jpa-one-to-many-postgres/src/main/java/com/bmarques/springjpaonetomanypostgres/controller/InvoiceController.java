package com.bmarques.springjpaonetomanypostgres.controller;

import com.bmarques.springjpaonetomanypostgres.domain.InvoiceEntity;
import com.bmarques.springjpaonetomanypostgres.domain.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;
    @PostMapping
    public InvoiceEntity saveInvoice(@RequestBody InvoiceEntity invoiceEntity) {
        return service.save(invoiceEntity);
    }
}
