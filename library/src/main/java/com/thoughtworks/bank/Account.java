package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MINIMUM_BALANCE;

    static {
        MINIMUM_BALANCE = 1000;
    }

    private final AccountNumber accountNumber;
    private double balance;

    public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.accountNumber = accountNumber;
        checkMinimumBalance(balance);
        this.balance = balance;
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

    public double withdraw(float amount) throws MinimumBalanceException {
        double bal=this.balance-amount;
        checkMinimumBalance(bal);
        this.balance = bal;
        return getBalance();
    }
}
