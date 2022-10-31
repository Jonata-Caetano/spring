package com.bmarques.springarchunitmvcexample.service;

import com.bmarques.springarchunitmvcexample.domain.invoice.Invoice;
import com.bmarques.springarchunitmvcexample.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private InvoiceRepository repository;

    public Invoice getInvoice() {
        return repository.getInvoice();
    }
}
