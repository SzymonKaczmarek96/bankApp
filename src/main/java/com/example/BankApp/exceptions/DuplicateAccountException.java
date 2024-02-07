package com.example.BankApp.exceptions;

public class DuplicateAccountException extends RuntimeException {

    private static final String MESSAGE = "Account about this number is existing in date base";

    public DuplicateAccountException() {
        super(MESSAGE);
    }
}
