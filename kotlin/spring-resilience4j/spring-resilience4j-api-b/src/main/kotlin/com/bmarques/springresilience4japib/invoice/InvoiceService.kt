package com.bmarques.springresilience4japib.invoice

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class InvoiceService {

    fun findAll(): List<Invoice> {
        return listOf(
                Invoice(1, LocalDate.now(), "123", 10, 2.0),
                Invoice(2, LocalDate.now(), "456", 20, 4.0),
                Invoice(2, LocalDate.now(), "789", 30, 6.0)
        )
    }
}