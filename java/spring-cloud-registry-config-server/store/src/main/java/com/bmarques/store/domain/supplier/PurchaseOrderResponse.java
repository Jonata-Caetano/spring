package com.bmarques.store.domain.supplier;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseOrderResponse {

    private Long id;
    private Integer preparationTime;
}