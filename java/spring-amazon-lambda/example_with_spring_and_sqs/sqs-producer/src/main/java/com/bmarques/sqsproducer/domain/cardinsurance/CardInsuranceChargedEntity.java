package com.bmarques.sqsproducer.domain.cardinsurance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public String toString() {
        return "{" +
                "\"maskedCardNumber\": \"" + maskedCardNumber + "\"" +
                ", \"cardToken\": \"" + cardToken + "\"" +
                ", \"productId\": " + productId +
                ", \"planId\": \"" + planId + "\"" +
                ", \"logoId\": \"" + logoId + "\"" +
                ", \"userName\": \"" + userName + "\"" +
                ", \"attendingId\": \"" + attendingId + "\"" +
                ", \"complementaryText\": \"" + complementaryText + "\"" +
                '}';
    }
}

