package com.inverse;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return this.balance;
    }

    void setBalance(double sum) {
        this.balance = sum;
    }
}
