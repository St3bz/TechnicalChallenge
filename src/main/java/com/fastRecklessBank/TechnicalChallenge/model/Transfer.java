package com.fastRecklessBank.TechnicalChallenge.model;

public class Transfer {
    int senderID;
    int receiverID;
    double amount;
    int timestamp;

    public Transfer(int senderID, int receiverID, double amount, int timestamp) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.amount = amount;
        this.timestamp = timestamp;
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
    public int getTimestamp() {
        return this.timestamp;
    }
}
