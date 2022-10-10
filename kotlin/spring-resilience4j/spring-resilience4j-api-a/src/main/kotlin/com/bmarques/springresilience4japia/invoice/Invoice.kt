package com.bmarques.springresilience4japia.invoice

import java.time.LocalDate

data class Invoice(
        val id: Int,
        val installmentDate: LocalDate,
        val document: String,
        val participantId: Int,
        val value: Double
)