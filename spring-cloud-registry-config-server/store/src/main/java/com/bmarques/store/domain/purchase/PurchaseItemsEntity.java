package com.bmarques.store.domain.purchase;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItemsEntity {

    private Integer id;
    private Integer count;
}
