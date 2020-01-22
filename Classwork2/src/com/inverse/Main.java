package com.inverse;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Privat");
        bank.setNewUser("Gogo", 456);
        bank.setNewUser("Bobo", 456);
        bank.startTransaction(0,1,45);
    }
}
