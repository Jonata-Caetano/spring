package com.bmarques.springmongo.invoice

import org.springframework.stereotype.Service

@Service
class InvoiceService(private val repository: InvoiceRepository) {
    fun save(invoice: Invoice): Invoice = repository.save(invoice)

    fun findById(id: Int): Invoice = repository.findById(id).orElseThrow { InvoiceNotFoundException("ID $id not found") }

    fun findAll(): List<Invoice> = repository.findAll()

    fun deleteById(id: Int) = repository.deleteById(id)
}
