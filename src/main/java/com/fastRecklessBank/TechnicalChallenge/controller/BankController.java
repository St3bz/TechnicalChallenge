package com.fastRecklessBank.TechnicalChallenge.controller;

import com.fastRecklessBank.TechnicalChallenge.model.Account;
import com.fastRecklessBank.TechnicalChallenge.model.DepositRequest;
import com.fastRecklessBank.TechnicalChallenge.model.Transfer;
import com.fastRecklessBank.TechnicalChallenge.model.WithdrawRequest;
import com.fastRecklessBank.TechnicalChallenge.service.BankService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    private final BankService bankService;

    BankController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping
    public Collection<Account> getAllAccounts() {
        return bankService.getAllAccounts(); // Return all accounts as a list
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        
        return bankService.createAccount(account.getKontostand());
    }
    
    @PostMapping("/deposit")
    public Account deposit(@RequestBody DepositRequest request) {
        
        return bankService.deposit(request.getAccountID(), request.getAmount());
    }

    @PostMapping("withdraw")
    public Account withdraw(@RequestBody WithdrawRequest request) {
        
        return bankService.withdraw(request.getAccountID(), request.getAmount());
    }

    @PostMapping("/api/accounts/{id}/transfer")
    public Account transfer(@PathVariable int id, @RequestBody Transfer request) {
        
        return bankService.transfer(id, request.getReceiverID(), request.getAmount());
    }
    

}
