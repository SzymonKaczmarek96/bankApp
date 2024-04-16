package com.example.BankApp.exceptions;

public class PasswordNotConditionsException extends RuntimeException{

    private static final String MESSAGE = "Password doesn't meet the conditions";


    public PasswordNotConditionsException(){
        super(MESSAGE);
    }

}
