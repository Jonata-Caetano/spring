
package com.tr.bluemoon.springunittestmock.services;

import com.tr.bluemoon.springunittestmock.model.Invoice;
import com.tr.bluemoon.springunittestmock.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServices {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void update(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void delete(Integer id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        if (invoice.isPresent()){
            invoiceRepository.deleteById(id);
        }
    }
}