package com.bmarques.supplier.api.supplier;

import com.bmarques.supplier.domain.supplier.SupplierEntity;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierResponse toResponse(SupplierEntity entity) {
        return SupplierResponse.builder()
                .id(entity.getId())
                .address(entity.getAdress())
                .name(entity.getName())
                .state(entity.getState())
                .build();
    }
}
