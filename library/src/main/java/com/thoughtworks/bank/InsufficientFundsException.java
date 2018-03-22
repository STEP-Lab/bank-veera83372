package com.thoughtworks.bank;

public class InsufficientFundsException extends Exception {
    InsufficientFundsException() {
        super("Insufficient funds in account");
    }
}
