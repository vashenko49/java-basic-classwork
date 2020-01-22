package com.inverse;

public class User {
    private String name;
    private Account account;
    public User(String name, double balance){
        this.name = name;
        this.account = new Account(balance);
    }
    Account getAccount (){
        return  account;
    }
}
