package com.example.BankingApp.Exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
