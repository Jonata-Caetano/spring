package com.bmarques.store.api.purchase;

import com.bmarques.store.domain.purchase.PurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class PurchaseController {

    private final PurchaseService service;
    private final PurchaseMapper mapper;

    public PurchaseController(PurchaseService service, PurchaseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public void save(@RequestBody PurchaseRequest purchaseRequest) {
        service.generatePurchase(mapper.toDto(purchaseRequest));
    }
}
