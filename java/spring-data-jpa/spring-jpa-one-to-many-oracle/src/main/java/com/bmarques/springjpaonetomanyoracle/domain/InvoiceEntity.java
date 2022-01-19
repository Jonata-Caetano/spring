package com.bmarques.springjpaonetomanyoracle.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "invoice")
public class InvoiceEntity {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer document;

    private Double value;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItemEntity> itemEntityList;
}
