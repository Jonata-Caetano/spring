package com.bmarques.springmongo.invoice

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDate

@Document(collection = "Invoice")
data class Invoice(
        @Id val id: Int,
        val installmentDate: LocalDate,
        @Field("document")
        val documentNumber: String,
        val client: String,
        val value: Double,
        val discount: Double
)
