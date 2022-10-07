package com.bmarques.springresilience4japia.revenue;

import com.bmarques.springresilience4japia.invoice.Invoice;
import com.bmarques.springresilience4japia.invoice.InvoiceClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RevenueService {

    @Autowired
    private InvoiceClient invoiceClient;

    @CircuitBreaker(name = "invoiceApi", fallbackMethod = "fallToGetTotalRevenue")
    public Double getTotalRevenue() {
        List<Invoice> invoices = invoiceClient.getInvoices();

        return invoices.stream()
                .map(Invoice::getValue)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public Double fallToGetTotalRevenue(Throwable e) {
        log.info("Fallback activated");
        return 0D;
    }
}
