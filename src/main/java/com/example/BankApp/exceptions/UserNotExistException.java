package com.example.BankApp.exceptions;

public class UserNotExistException extends RuntimeException{

    private final static String MESSAGE = "User doesn't exist";
    public UserNotExistException() {
        super(MESSAGE);
    }
}
