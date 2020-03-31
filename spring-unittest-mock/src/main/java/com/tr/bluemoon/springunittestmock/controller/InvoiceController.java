package com.tr.bluemoon.springunittestmock.controller;

import com.tr.bluemoon.springunittestmock.model.Invoice;
import com.tr.bluemoon.springunittestmock.services.InvoiceServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice")
@CrossOrigin
public class InvoiceController {

    private Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private InvoiceServices invoiceServices;

    @GetMapping
    public List<Invoice> findAll() {
        return invoiceServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Integer id, UriComponentsBuilder uriComponentsBuilder) {
        Optional<Invoice> invoice = invoiceServices.findById(id);

        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping
    public ResponseEntity<Invoice> save(@RequestBody Invoice invoice, UriComponentsBuilder uriBuilder) {

        logger.info(invoice.toString());
        invoiceServices.save(invoice);

        URI uri = uriBuilder.path("/invoice/{id}").buildAndExpand(invoice.getId()).toUri();
        return ResponseEntity.created(uri).body(invoice);
    }
}