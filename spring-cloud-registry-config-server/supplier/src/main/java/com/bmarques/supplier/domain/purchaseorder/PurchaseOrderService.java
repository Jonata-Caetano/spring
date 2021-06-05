package com.bmarques.supplier.domain.purchaseorder;

import com.bmarques.supplier.domain.product.ProductEntity;
import com.bmarques.supplier.domain.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ProductRepository productRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, ProductRepository productRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.productRepository = productRepository;
    }

    public PurchaseOrderEntity generatePurchaseOrder(List<PurchaseOrderDto> purchaseOrderItemsRequest) {

        if (purchaseOrderItemsRequest == null) {
            return null;
        }

        List<PurchaseOrderItemEntity> purchaseOrderItems = toPurchaseOrderItem(purchaseOrderItemsRequest);

        return purchaseOrderRepository.save(PurchaseOrderEntity.builder()
                .items(purchaseOrderItems)
                .status(PurchaseOrderStatus.RECEIVED)
                .preparationTime(purchaseOrderItems.size())
                .build());
    }

    public PurchaseOrderEntity getPurchaseOrderById(Long id) {
        return this.purchaseOrderRepository.findById(id).orElse(new PurchaseOrderEntity());
    }

    private List<PurchaseOrderItemEntity> toPurchaseOrderItem(List<PurchaseOrderDto> items) {

        List<Long> productsIds = items
                .stream()
                .map(PurchaseOrderDto::getId)
                .collect(Collectors.toList());

        List<ProductEntity> purchaseProducts = productRepository.findByIdIn(productsIds);

        return items
                .stream()
                .map(item -> PurchaseOrderItemEntity.builder()
                        .product(purchaseProducts
                                .stream()
                                .filter(p -> p.getId() == item.getId())
                                .findFirst()
                                .get())
                        .count(item.getCount())
                        .build())
                .collect(Collectors.toList());
    }
}
