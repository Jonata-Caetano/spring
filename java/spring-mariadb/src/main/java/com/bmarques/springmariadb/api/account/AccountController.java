package com.bmarques.springmariadb.api.account;

import com.bmarques.springmariadb.domain.account.AccountEntity;
import com.bmarques.springmariadb.domain.account.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountEntity> getAccount(@PathVariable Integer id) {
        Optional<AccountEntity> accountEntity = service.getAccountEntity(id);

        return accountEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAllAccount() {
        return ResponseEntity.ok(service.getAllAccount());
    }
}
