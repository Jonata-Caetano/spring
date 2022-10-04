package com.bmarques.springresilience4japia.revenue;

import com.bmarques.springresilience4japia.invoice.Invoice;
import com.bmarques.springresilience4japia.invoice.InvoiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {

    @Autowired
    private InvoiceClient invoiceClient;

    public Double getTotalRevenue() {
        List<Invoice> invoices = invoiceClient.getInvoices();

        return invoices.stream()
                .map(Invoice::getValue)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
