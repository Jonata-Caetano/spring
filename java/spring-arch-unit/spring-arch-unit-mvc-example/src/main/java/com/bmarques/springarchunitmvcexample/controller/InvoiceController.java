package com.bmarques.springarchunitmvcexample.controller;

import com.bmarques.springarchunitmvcexample.domain.invoice.Invoice;
import com.bmarques.springarchunitmvcexample.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    //VIOLATION_RULE
//    @Autowired
    private InvoiceService service;

    //VIOLATION RULE
    //    @Autowired
//        private InvoiceRepository repository;

    @GetMapping
    public Invoice getInvoice() {
        return service.getInvoice();
    }

    //VIOLATION RULE
    //    @GetMapping
    //    public Invoice getInvoiceFromRepository() {
    //        return repository.getInvoice();
    //    }
}
