package com.example.BankingApp.controllers;

import com.example.BankingApp.dto.AccountDto;
import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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



    @GetMapping("/myAccounts/{id}")
    public ResponseEntity<List<AccountResponse>> getAcctByCusId(@PathVariable Long id){
        return status(HttpStatus.OK).body(accountService.getAccountByCusId(id));
    }

    @GetMapping("/acctNum/{num}")
    public ResponseEntity<AccountResponse> getAcctByAcctNum(@PathVariable int num){
        return status(HttpStatus.OK).body(accountService.getAcctByAcctNum(num));
    }



}
