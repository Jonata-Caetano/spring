package com.bmarques.cardinsurancecharge.cardinsurance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardInsuranceChargedEntity {

    private String maskedCardNumber;
    private String cardToken;
    private Integer productId;
    private String planId;
    private String logoId;
    private String userName;
    private String attendingId;
    private String complementaryText;
}
