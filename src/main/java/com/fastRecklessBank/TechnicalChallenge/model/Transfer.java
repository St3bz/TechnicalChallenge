package com.fastRecklessBank.TechnicalChallenge.model;

public class Transfer {
    int senderID;
    int receiverID;
    double amount;
    

    public Transfer(int senderID, int receiverID, double amount) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.amount = amount;
        
    }
    
    public int getSenderID() {
        return this.senderID;
    }
    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }
    public int getReceiverID() {
        return this.receiverID;
    }
    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }
    public double getAmount() {
        return this.amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
}
