package com.fastRecklessBank.TechnicalChallenge.repository;

import java.util.ArrayList;
import java.util.Collection;

import com.fastRecklessBank.TechnicalChallenge.model.Account;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    private Map<Object, Account> accounts = new HashMap<>();
    private int nextId = 1;

    public Account save(Account account) {
        if (account.getId() == 0) {
            account.setId(nextId++);
        }
        accounts.put(account.getId(), account);
        return account;
    }
    public Account findById(int id) {
        return accounts.get(id);
    }
    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }


}
