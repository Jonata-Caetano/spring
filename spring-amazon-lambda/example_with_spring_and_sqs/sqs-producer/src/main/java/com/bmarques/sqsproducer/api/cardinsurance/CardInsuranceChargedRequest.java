package com.bmarques.sqsproducer.api.cardinsurance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardInsuranceChargedRequest {

    private String maskedCardNumber;
    private String cardToken;
    private Integer productId;
    private String planId;
    private String logoId;
    private String userName;
    private String attendingId;
    private String complementaryText;

}