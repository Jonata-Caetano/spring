package com.bmarques.store.domain.purchase;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseEntity {

    private Long id;
    private Long purchaseOrderId;
    private Integer preparationTime;
    private String addressDestiny;

}
