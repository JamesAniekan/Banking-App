package com.example.BankingApp.controllers;

import com.example.BankingApp.dto.AccountDto;
import com.example.BankingApp.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AccountController {

    AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> newAccount(@RequestBody AccountDto accountDto){

        accountService.createAccount(accountDto);

         return new ResponseEntity<>("New account created",  HttpStatus.CREATED);
    }


}
