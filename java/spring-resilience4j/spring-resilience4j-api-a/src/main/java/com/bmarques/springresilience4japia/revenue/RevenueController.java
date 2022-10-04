package com.bmarques.springresilience4japia.revenue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

    @Autowired
    private RevenueService service;

    @GetMapping
    public Double getTotalRevenue() {
        return service.getTotalRevenue();
    }
}
