package com.bmarques.sqsproducer.api.cardinsurance;

import com.bmarques.sqsproducer.domain.cardinsurance.CardInsuranceChargedEntity;
import org.springframework.stereotype.Component;

@Component
public class CardInsuranceMapper {

    public CardInsuranceChargedEntity toEntity(CardInsuranceChargedRequest cardInsuranceChargedRequest) {
        return CardInsuranceChargedEntity.builder()
                .maskedCardNumber(cardInsuranceChargedRequest.getMaskedCardNumber())
                .cardToken(cardInsuranceChargedRequest.getCardToken())
                .productId(cardInsuranceChargedRequest.getProductId())
                .planId(cardInsuranceChargedRequest.getPlanId())
                .logoId(cardInsuranceChargedRequest.getLogoId())
                .userName(cardInsuranceChargedRequest.getUserName())
                .attendingId(cardInsuranceChargedRequest.getAttendingId())
                .complementaryText(cardInsuranceChargedRequest.getComplementaryText())
                .build();
    }
}