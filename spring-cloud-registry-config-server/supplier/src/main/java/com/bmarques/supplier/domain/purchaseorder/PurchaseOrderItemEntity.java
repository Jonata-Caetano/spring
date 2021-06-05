package com.bmarques.supplier.domain.purchaseorder;

import com.bmarques.supplier.domain.product.ProductEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "purchase_order_item")
public class PurchaseOrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
