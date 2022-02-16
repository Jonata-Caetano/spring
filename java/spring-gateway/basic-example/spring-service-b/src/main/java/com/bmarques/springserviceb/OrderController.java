package com.bmarques.springserviceb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @GetMapping
    public String getOrder() {
        return "Is Order!";
    }

    @GetMapping("/private")
    public String getOrderPrivate() {
        return "Is Order, Private!";
    }
}
