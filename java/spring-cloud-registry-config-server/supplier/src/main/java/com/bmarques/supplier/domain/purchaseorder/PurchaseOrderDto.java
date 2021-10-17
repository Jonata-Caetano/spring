package com.bmarques.supplier.domain.purchaseorder;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDto {

    private long id;
    private int count;
}
