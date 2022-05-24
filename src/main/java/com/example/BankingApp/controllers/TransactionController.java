package com.example.BankingApp.controllers;


import com.example.BankingApp.dto.TransactionDto;
import com.example.BankingApp.services.TransactionService;
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
public class TransactionController {

    TransactionService transactionService;

    @PostMapping("/doTransaction")
    public ResponseEntity<String> doTransaction(@RequestBody TransactionDto transactionDto){
        transactionService.doTransaction(transactionDto);

        return new ResponseEntity<>("Transaction successful", HttpStatus.CREATED);
    }
}
