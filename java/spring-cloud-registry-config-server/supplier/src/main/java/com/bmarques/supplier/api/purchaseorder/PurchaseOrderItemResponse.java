package com.bmarques.supplier.api.purchaseorder;

import com.bmarques.supplier.domain.product.ProductEntity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemResponse {

    private Long id;
    private Integer count;
    private ProductEntity product;
}
