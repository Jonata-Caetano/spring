package com.bmarques.springarchunitmvcexample.domain.invoice

import com.bmarques.springarchunitmvcexample.domain.customer.Customer
import java.time.LocalDate

abstract class Invoice {
    abstract val id: Int
    abstract val installment: LocalDate
    abstract val value: Double
    abstract val customer: Customer
}
