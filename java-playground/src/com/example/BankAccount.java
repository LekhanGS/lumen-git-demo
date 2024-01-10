package com.example;

public class BankAccount {
    private double balance;
    private String accountHolder; // fields are written in camel case
    private int accountNumber;

    public BankAccount(double balance, String accountHolder, int accountNumber) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String accountHolder, int accountNumber) {
        this(0,accountHolder,accountNumber);
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
        }
    }
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
        }
    }
}