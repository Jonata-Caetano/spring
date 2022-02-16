package com.bmarques.springservicea;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    @GetMapping
    public String getMerchant() {
        return "Is Merchant!";
    }

    @DeleteMapping
    public String deleteMerchant() {
        return "Is Merchant Deleted!";
    }

    @GetMapping("/hello")
    public String getMerchantHealth() {
        return "Is Merchant, Hello World!";
    }
}
