package com.fastRecklessBank.TechnicalChallenge.model;

public class WithdrawRequest {
    private double amount;
    public int accountID;

    public WithdrawRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
