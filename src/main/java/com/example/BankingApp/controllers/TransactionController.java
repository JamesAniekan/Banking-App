package com.example.BankingApp.controllers;


import com.example.BankingApp.dto.TransactionDto;
import com.example.BankingApp.dto.TransactionResponse;
import com.example.BankingApp.models.Transaction;
import com.example.BankingApp.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TransactionController {

    TransactionService transactionService;

    @PostMapping("/doTransaction")
    public ResponseEntity<String> doTransaction(@RequestBody TransactionDto transactionDto){
        transactionService.doTransaction(transactionDto);

        return new ResponseEntity<>("Transaction successful", HttpStatus.CREATED);
    }

    //List of transactions performed on an account.
    @GetMapping("/transactions/{acctNum}")
    public ResponseEntity<List<TransactionResponse>> getTransactions(@PathVariable int acctNum){
        return status(HttpStatus.OK).body(transactionService.getTransactions(acctNum));
    }
}
