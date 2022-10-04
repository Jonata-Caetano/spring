package com.bmarques.springresilience4japia.invoice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
@FeignClient(name = "invoiceservice", url = "${api.message.center.url}")
public interface InvoiceClient {
    @GetMapping(value = "/invoice", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Invoice> getInvoices();
}