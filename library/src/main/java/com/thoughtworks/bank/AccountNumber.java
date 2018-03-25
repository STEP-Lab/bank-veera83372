package com.thoughtworks.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountNumber {
    private static final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{4}");
    private String accountNumber;

    public AccountNumber(String accountNumber) throws InvalidAccountNumberException {
        validateAccountNumber(accountNumber);
        this.accountNumber = accountNumber;
    }

    private void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException  {
        Matcher matcher = PATTERN.matcher(accountNumber);
        if (!matcher.matches()) {
            throw new InvalidAccountNumberException();
        }
    }
}
