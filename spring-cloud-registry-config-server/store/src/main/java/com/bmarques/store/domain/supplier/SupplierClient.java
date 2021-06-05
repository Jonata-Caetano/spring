package com.bmarques.store.domain.supplier;

import com.bmarques.store.domain.purchase.PurchaseItemsEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("supplier")
public interface SupplierClient {

    @GetMapping("supplier/{state}")
    SupplierInfo getSupplierByState(@PathVariable String state);

    @PostMapping("/purchase-order")
    PurchaseOrderResponse generatePurchaseOrder(List<PurchaseItemsEntity> items);
}
