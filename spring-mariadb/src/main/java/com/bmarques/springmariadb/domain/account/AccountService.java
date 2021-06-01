package com.bmarques.springmariadb.domain.account;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Optional<AccountEntity> getAccountEntity(final Integer id) {
        return repository.findById(id);
    }

    public List<AccountEntity> getAllAccount() {
        return repository.findAll();
    }
}
