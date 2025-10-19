package com.fastRecklessBank.TechnicalChallenge.service;

import org.springframework.stereotype.Service;

import com.fastRecklessBank.TechnicalChallenge.model.Account;
import com.fastRecklessBank.TechnicalChallenge.repository.AccountRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {
    
    private AccountRepository accountRepository;
    private final Map<Integer, Account> accounts = new HashMap<>(); // In-memory storage for accounts

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount( double initialBalance) {
        Account newAccount = new Account(0,initialBalance);
        return accountRepository.save(newAccount) ;
    }

    public Account deposit(int accountId, double amount) {

        Account account = accountRepository.findById(accountId);
    
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }   

        double newBalance = account.getKontostand() + amount;

        account.setKontostand(newBalance);

        accountRepository.save(account);

        return account;

    }

    public Account withdraw(int accountId, double amount) {

        Account account = accountRepository.findById(accountId);
    
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }   

        if (account.getKontostand() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        double newBalance = account.getKontostand() - amount;

        account.setKontostand(newBalance);

        accountRepository.save(account);

        return account;
    }
    public Account transfer(int senderId, int receiverId, double amount) {

        Account senderAccount = accountRepository.findById(senderId);
        Account receiverAccount = accountRepository.findById(receiverId);
    
        if (senderAccount == null || receiverAccount == null) {
            throw new IllegalArgumentException("Sender or receiver account not found");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }   

        if (senderAccount.getKontostand() < amount) {
            throw new IllegalArgumentException("Insufficient funds in sender's account");
        }

        double newSenderBalance = senderAccount.getKontostand() - amount;
        double newReceiverBalance = receiverAccount.getKontostand() + amount;

        senderAccount.setKontostand(newSenderBalance);
        receiverAccount.setKontostand(newReceiverBalance);

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
        return senderAccount;
    }
    
    public List<Account> getAllAccounts() {
        return accountRepository.findAll(); // Return all accounts stored in the map
    }

    public Account save(Account account) {
        if (account != null) {
            accounts.put(account.getId(), account); // Save or update the account in the map
        }
        return account; // Return the saved or updated account
    }
}
