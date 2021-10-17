package com.bmarques.supplier.api.supplier;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResponse {

    private Long id;
    private String name;
    private String state;
    private String address;
}
