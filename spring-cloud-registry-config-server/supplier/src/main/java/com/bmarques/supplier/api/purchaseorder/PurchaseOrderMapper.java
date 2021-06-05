package com.bmarques.supplier.api.purchaseorder;

import com.bmarques.supplier.domain.purchaseorder.PurchaseOrderDto;
import com.bmarques.supplier.domain.purchaseorder.PurchaseOrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PurchaseOrderMapper {

    public List<PurchaseOrderDto> toDto(List<PurchaseOrderRequest> purchaseOrderRequestList) {
        return purchaseOrderRequestList.stream()
                .map(purchaseOrderRequest -> PurchaseOrderDto.builder()
                        .id(purchaseOrderRequest.getId())
                        .count(purchaseOrderRequest.getCount())
                        .build())
                .collect(Collectors.toList());
    }

    public PurchaseOrderResponse toResponse(PurchaseOrderEntity purchaseOrderEntity) {
        return PurchaseOrderResponse.builder()
                .id(purchaseOrderEntity.getId())
                .items(purchaseOrderEntity.getItems().stream()
                        .map(purchaseOrderItemEntity -> PurchaseOrderItemResponse.builder()
                                .id(purchaseOrderItemEntity.getId())
                                .count(purchaseOrderItemEntity.getCount())
                                .build())
                        .collect(Collectors.toList()))
                .preparationTime(purchaseOrderEntity.getPreparationTime())
                .status(purchaseOrderEntity.getStatus())
                .build();
    }
}
