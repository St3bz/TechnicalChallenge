package com.fastRecklessBank.TechnicalChallenge.repository;

import java.util.Collection;

import com.fastRecklessBank.TechnicalChallenge.model.Account;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    private Map<Object, Account> accounts = new HashMap<>();

    public Account findById(int id) {
        return accounts.get(id);
    }
    public Account save(Account account) {
        return accounts.put(account.getId(), account);
    }
    public Collection<Account> findAll() {
        return accounts.values();
    }

}
