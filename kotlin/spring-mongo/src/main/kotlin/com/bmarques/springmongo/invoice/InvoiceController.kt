package com.bmarques.springmongo.invoice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoice")
class InvoiceController(private val service: InvoiceService) {

    @PostMapping
    fun save(@RequestBody invoice: Invoice): Invoice = service.save(invoice)

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Invoice = service.findById(id)

    @GetMapping
    fun findAll(): List<Invoice> = service.findAll()

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int,
               @RequestBody invoiceRequest: Invoice): Invoice {
        val invoiceSaved = service.findById(id)
        return service.save(Invoice(
                id = invoiceSaved.id,
                installmentDate = invoiceRequest.installmentDate,
                documentNumber = invoiceRequest.documentNumber,
                client = invoiceRequest.client,
                value = invoiceRequest.value,
                discount = invoiceRequest.discount
        ))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteById(@PathVariable id: Int) = service.deleteById(id)
}