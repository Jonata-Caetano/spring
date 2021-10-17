package com.bmarques.supplier.api.purchaseorder;

import com.bmarques.supplier.domain.purchaseorder.PurchaseOrderStatus;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderResponse {

    private Long id;
    private Integer preparationTime;
    private PurchaseOrderStatus status;
    private List<PurchaseOrderItemResponse> items;
}
