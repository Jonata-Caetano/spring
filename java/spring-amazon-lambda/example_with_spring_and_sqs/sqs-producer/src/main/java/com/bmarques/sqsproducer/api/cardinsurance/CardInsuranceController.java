package com.bmarques.sqsproducer.api.cardinsurance;

import com.bmarques.sqsproducer.domain.cardinsurance.CardInsuranceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-insurance")
public class CardInsuranceController {

    private final CardInsuranceService cardInsuranceService;
    private final CardInsuranceMapper mapper;

    public CardInsuranceController(CardInsuranceService cardInsuranceService, CardInsuranceMapper mapper) {
        this.cardInsuranceService = cardInsuranceService;
        this.mapper = mapper;
    }

    @PostMapping("/charged")
    public void saveCharged(@RequestBody CardInsuranceChargedRequest cardInsuranceChargedRequest) {
        var cardInsuranceChargedEntity = mapper.toEntity(cardInsuranceChargedRequest);
        cardInsuranceService.save(cardInsuranceChargedEntity);
    }
}