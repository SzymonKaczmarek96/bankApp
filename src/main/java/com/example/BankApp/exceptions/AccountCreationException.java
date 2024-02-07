package com.example.BankApp.exceptions;

public class AccountCreationException extends RuntimeException{

    private static final String MESSAGE = "Failed to create account";

    public AccountCreationException(){
        super(MESSAGE);
    }

}
