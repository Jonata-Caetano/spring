package com.tr.bluemoon.springunittestmock.services;

import com.tr.bluemoon.springunittestmock.model.Invoice;
import com.tr.bluemoon.springunittestmock.model.Tax;
import com.tr.bluemoon.springunittestmock.repository.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaxServices {

    @Autowired
    private InvoiceServices invoiceServices;

    @Autowired
    private TaxRepository taxRepository;

    public Tax calulation() {
        List<Invoice> invoices = invoiceServices.findAll();

        invoices.stream().forEach(invoice -> System.out.println(invoice.getValue().multiply(BigDecimal.valueOf(0.02))));

        return new Tax(1, LocalDate.of(2019, 10, 1), BigDecimal.valueOf(100));
    }

    public void save(Tax tax){
        taxRepository.save(tax);
    }
}
