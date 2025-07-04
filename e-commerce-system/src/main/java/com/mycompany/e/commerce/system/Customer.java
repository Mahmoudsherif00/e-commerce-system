package com.mycompany.e.commerce.system;

public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canAfford(double amount) {                   // See if the customer has enough money to buy something
        return balance >= amount;
    }

    public void pay(double amount) {                           // Take the money from the customer's balance after they pay
        balance -= amount;
    }
}
