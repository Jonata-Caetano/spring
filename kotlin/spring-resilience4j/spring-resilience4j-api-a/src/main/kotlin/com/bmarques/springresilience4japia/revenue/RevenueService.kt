package com.bmarques.springresilience4japia.revenue

import com.bmarques.springresilience4japia.invoice.Invoice
import com.bmarques.springresilience4japia.invoice.InvoiceClient
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class RevenueService(private val invoiceClient: InvoiceClient) {

    @CircuitBreaker(name = "invoiceApi", fallbackMethod = "fallToGetTotalRevenue")
    fun getTotalRevenue(): Double {
        val invoices = invoiceClient.getInvoices()
        return invoices.stream()
                .map(Invoice::value)
                .mapToDouble { obj: Double -> obj }
                .sum()
    }

    fun fallToGetTotalRevenue(e: Throwable): Double = 0.0
}