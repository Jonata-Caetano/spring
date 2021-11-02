package com.bmarques.springkafkaavroproducer.merchant;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MerchantEntity {

    private UUID id;

    private String name;

    private String slug;

    private Boolean delivery;

    private String whatsAppPhone;
}