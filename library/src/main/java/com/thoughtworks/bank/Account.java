package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private static final int MinimumBalance;

    static {
        MinimumBalance = 1000;
    }

    private final AccountNumber accountNumber;
    private int balance;

    public Account(AccountNumber accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        this.accountNumber = accountNumber;
        if(balance<MinimumBalance){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public float withdraw(float amount) throws  InsufficientFundsException{
        if(balance < amount) {
            throw new InsufficientFundsException();
        }
        return balance -= amount;
    }
}
