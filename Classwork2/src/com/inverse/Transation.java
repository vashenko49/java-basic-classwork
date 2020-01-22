package com.inverse;

public class Transation {
    public boolean Run(Account from, Account to, double sum) {
        if (sum > from.getBalance()) {
            return false;
        } else {
            from.setBalance(from.getBalance() - sum);
            to.setBalance(to.getBalance() + sum);
            return true;
        }
    }
}
