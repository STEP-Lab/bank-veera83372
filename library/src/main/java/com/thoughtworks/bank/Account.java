package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    public static final int MinimumBalance;
    private static final Pattern PATTERN;

    static {
        PATTERN = Pattern.compile("\\d{4}[-]\\d{4}");
        MinimumBalance = 1000;
    }

    private final String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) throws MinimumBalanceException, InvalidAccountNumberException {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()){
            throw new InvalidAccountNumberException();
        }

        this.accountNumber = accountNumber;
        if(balance<MinimumBalance){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
