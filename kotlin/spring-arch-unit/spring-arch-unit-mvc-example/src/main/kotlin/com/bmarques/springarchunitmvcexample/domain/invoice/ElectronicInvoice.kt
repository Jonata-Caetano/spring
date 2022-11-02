package com.bmarques.springarchunitmvcexample.domain.invoice

import com.bmarques.springarchunitmvcexample.domain.customer.Customer
import java.time.LocalDate


data class ElectronicInvoice(
        override val id: Int,
        override val installment: LocalDate,
        override val value: Double,
        override val customer: Customer) : Invoice()
