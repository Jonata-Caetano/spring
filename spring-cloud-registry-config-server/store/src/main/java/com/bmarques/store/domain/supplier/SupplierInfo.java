package com.bmarques.store.domain.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierInfo {

    private Long id;
    private String name;
    private String state;
    private String address;

}
