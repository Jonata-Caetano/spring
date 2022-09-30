package com.bmarques.springmongo.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping
    public Invoice save(@RequestBody Invoice invoice) {
        return service.save(invoice);
    }

    @GetMapping("/{id}")
    public Invoice findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<Invoice> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Invoice update(@PathVariable Integer id,
                          @RequestBody Invoice invoiceRequest) {
        Invoice invoiceSaved = service.findById(id);
        invoiceSaved.setInstallmentDate(invoiceRequest.getInstallmentDate());
        invoiceSaved.setDocumentNumber(invoiceRequest.getDocumentNumber());
        invoiceSaved.setClient(invoiceRequest.getClient());
        invoiceSaved.setValue(invoiceRequest.getValue());
        invoiceSaved.setDiscount(invoiceRequest.getDiscount());
        return service.save(invoiceSaved);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
