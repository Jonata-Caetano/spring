package com.bmarques.springarchunitmvcexample.service

import com.bmarques.springarchunitmvcexample.domain.invoice.ElectronicInvoice
import com.bmarques.springarchunitmvcexample.repository.InvoiceRepository
import org.springframework.stereotype.Service

@Service
class InvoiceService(private val repository: InvoiceRepository) {

    fun getInvoice(): ElectronicInvoice = repository.getInvoice()
}