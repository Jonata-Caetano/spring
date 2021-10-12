package com.bmarques.springh2.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantRepository merchantRepository;

    @PostMapping
    public MerchantEntity addMerchant(@RequestBody MerchantEntity merchantEntity) {
        return merchantRepository.save(merchantEntity);
    }

    @GetMapping
    public List<MerchantEntity> getAllMerchant() {
        return merchantRepository.findAll();
    }
}
