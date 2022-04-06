package com.bmarques.springkakaproducer.merchant.api;

import com.bmarques.springkakaproducer.merchant.domain.MerchantEntity;
import com.bmarques.springkakaproducer.merchant.domain.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService service;

    @GetMapping
    public List<MerchantEntity> findAll() {
        return service.findAll();
    }

    @PostMapping
    public MerchantEntity save(@RequestBody MerchantEntity request) {
        return service.save(request);
    }
}
