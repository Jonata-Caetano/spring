package com.bmarques.springarchunitmvcexample.controller

import com.bmarques.springarchunitmvcexample.domain.invoice.ElectronicInvoice
import com.bmarques.springarchunitmvcexample.service.InvoiceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invoice")
class InvoiceController(private val service: InvoiceService) {
    @GetMapping
    fun getInvoice(): ElectronicInvoice = service.getInvoice()
}