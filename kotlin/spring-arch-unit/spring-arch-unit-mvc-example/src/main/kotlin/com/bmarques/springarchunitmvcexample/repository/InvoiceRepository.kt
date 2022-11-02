package com.bmarques.springarchunitmvcexample.repository

import com.bmarques.springarchunitmvcexample.domain.address.Street
import com.bmarques.springarchunitmvcexample.domain.customer.Customer
import com.bmarques.springarchunitmvcexample.domain.invoice.ElectronicInvoice
import java.time.LocalDate

class InvoiceRepository {

    fun getInvoice(): ElectronicInvoice =
            ElectronicInvoice(1, LocalDate.now(), 50.0, Customer(1, "Tiago", Street("Jose Marcos Tome", 75)))
}