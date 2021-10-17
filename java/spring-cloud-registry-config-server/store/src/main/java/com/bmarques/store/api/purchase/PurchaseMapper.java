package com.bmarques.store.api.purchase;

import com.bmarques.store.domain.purchase.PurchaseAdressEntity;
import com.bmarques.store.domain.purchase.PurchaseDto;
import com.bmarques.store.domain.purchase.PurchaseItemsEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PurchaseMapper {

    public PurchaseDto toDto(final PurchaseRequest purchaseRequest) {
        return PurchaseDto.builder()
                .items(purchaseRequest.getItems().stream()
                        .map(request -> PurchaseItemsEntity.builder()
                                .id(request.getId())
                                .count(request.getCount())
                                .build())
                        .collect(Collectors.toList()))
                .adress(PurchaseAdressEntity.builder()
                        .number(purchaseRequest.getAdress().getNumber())
                        .street(purchaseRequest.getAdress().getStreet())
                        .state(purchaseRequest.getAdress().getState())
                        .build())
                .build();
    }
}
