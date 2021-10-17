package com.bmarques.store.domain.purchase;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseAdressEntity {

    private String street;
    private Integer number;
    private String state;
}
