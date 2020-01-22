package com.inverse;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<User> users;

    public Bank(String name) {
        this.name = name;
        users=new ArrayList<>() ;
    }

    void setNewUser(String name, double balance) {
        users.add(new User(name, balance));
    }

    void startTransaction(int from, int to, double sum) {
        Transation transation = new Transation();
        transation.Run(users.get(from).getAccount(), users.get(to).getAccount(), sum);
    }
}
