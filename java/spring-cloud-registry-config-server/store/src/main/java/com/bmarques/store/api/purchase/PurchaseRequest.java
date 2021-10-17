package com.bmarques.store.api.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

    private List<PurchaseItemsRequest> items;
    private PurchaseAdressRequest adress;
}
