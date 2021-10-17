package com.bmarques.store.domain.purchase;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    private Integer id;
    private List<PurchaseItemsEntity> items;
    private PurchaseAdressEntity adress;
}
