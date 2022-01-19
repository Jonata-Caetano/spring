package com.bmarques.springjpaonetomanypostgres.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invoice_item")
public class InvoiceItemEntity {

    @Id
    @Column(name = "invoice_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_code")
    private Integer productCode;

    @Column(name = "item_value")
    private Double value;

}
