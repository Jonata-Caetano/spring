package com.bmarques.springresilience4japia.revenue

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/revenue")
class RevenueController(private val revenueService: RevenueService) {

    @GetMapping
    fun getTotalRevenue() = revenueService.getTotalRevenue()

}