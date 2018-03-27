package com.thoughtworks.bank;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MINIMUM_BALANCE;
    private Transactions transactions;


    static {
        MINIMUM_BALANCE = 1000;
    }

    private final AccountNumber accountNumber;
    private double balance;

    public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.accountNumber = accountNumber;
        checkMinimumBalance(balance);
        this.balance = balance;
        transactions=new Transactions();
    }

    private static void checkMinimumBalance(double balance) throws MinimumBalanceException {
        if(balance<MINIMUM_BALANCE){
            throw new MinimumBalanceException();
        }
    }

    public double getBalance() {
        return balance;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public double withdraw(double amount,String to) throws MinimumBalanceException {
        double bal=this.balance-amount;
        checkMinimumBalance(bal);
        this.balance = bal;
        transactions.debit(amount,to);
        return getBalance();
    }
    public double credit(double amount, String to) {
        double balance = this.balance + amount;
        this.balance = balance;
        transactions.credit(amount, to);
        return this.getBalance();
    }
    public Transactions getTransactions() {
        return transactions;
    }
}
