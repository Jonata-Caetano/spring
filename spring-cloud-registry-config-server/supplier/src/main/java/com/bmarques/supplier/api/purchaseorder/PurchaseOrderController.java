package com.bmarques.supplier.api.purchaseorder;

import com.bmarques.supplier.domain.purchaseorder.PurchaseOrderEntity;
import com.bmarques.supplier.domain.purchaseorder.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase-order")
public class PurchaseOrderController {

    private final PurchaseOrderService service;
    private final PurchaseOrderMapper mapper;

    public PurchaseOrderController(PurchaseOrderService service, PurchaseOrderMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public PurchaseOrderResponse generatePurchaseOrder(@RequestBody List<PurchaseOrderRequest> purchaseOrderRequestList) {
        PurchaseOrderEntity purchaseOrderEntity = service.generatePurchaseOrder(mapper.toDto(purchaseOrderRequestList));
        return mapper.toResponse(purchaseOrderEntity);
    }

    @GetMapping("/{id}")
    public PurchaseOrderResponse getPurchaseOrderById(@PathVariable Long id) {
        return mapper.toResponse(service.getPurchaseOrderById(id));
    }
}
