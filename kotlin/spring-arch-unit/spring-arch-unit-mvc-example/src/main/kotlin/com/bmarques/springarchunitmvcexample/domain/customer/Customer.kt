package com.bmarques.springarchunitmvcexample.domain.customer

import com.bmarques.springarchunitmvcexample.domain.address.Street

data class Customer(val id: Int, val name: String, val street: Street)
