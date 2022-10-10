package com.bmarques.springresilience4japia.invoice

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping

@Repository
@FeignClient(name = "invoiceservice", url = "\${api.message.center.url}")
interface InvoiceClient {
    @GetMapping(value = ["/invoice"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getInvoices(): List<Invoice>
}