package com.example.BankApp.exceptions;

public class AccountNotExistException extends RuntimeException{

    private static final String MESSAGE = "Account doesn't exist";


    public AccountNotExistException() {
        super(MESSAGE);
    }
}
