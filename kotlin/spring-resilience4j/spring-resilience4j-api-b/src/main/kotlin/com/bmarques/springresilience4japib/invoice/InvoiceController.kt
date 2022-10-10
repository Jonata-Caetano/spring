package com.bmarques.springresilience4japib.invoice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoice")
class InvoiceController(val service: InvoiceService) {

    @GetMapping
    fun findAll(): List<Invoice> = service.findAll()
}