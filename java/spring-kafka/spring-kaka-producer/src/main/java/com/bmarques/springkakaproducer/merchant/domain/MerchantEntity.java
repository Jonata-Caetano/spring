package com.bmarques.springkakaproducer.merchant.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "merchant")
@ToString
public class MerchantEntity {

    @Id
    @Column(name = "merchant_id")
    private UUID id;

    private String name;

    private String slug;

    private Boolean delivery;

    @Column(name = "whats_app_phone")
    private String whatsAppPhone;
}