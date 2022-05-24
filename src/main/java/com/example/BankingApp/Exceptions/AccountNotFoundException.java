package com.example.BankingApp.Exceptions;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String errorMsg){
        super(errorMsg);
    }

}
