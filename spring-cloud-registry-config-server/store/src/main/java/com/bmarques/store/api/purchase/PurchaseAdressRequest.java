package com.bmarques.store.api.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseAdressRequest {

    private String street;
    private Integer number;
    private String state;

}
