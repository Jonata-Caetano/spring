package com.bmarques.springmongo.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    public Invoice save(Invoice invoice) {
        return repository.save(invoice);
    }

    public Invoice findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found"));
    }

    public List<Invoice> findAll() {
        return repository.findAll();
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
