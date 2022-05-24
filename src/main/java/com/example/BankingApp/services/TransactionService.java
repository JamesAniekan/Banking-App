package com.example.BankingApp.services;

import com.example.BankingApp.Exceptions.AccountNotFoundException;
import com.example.BankingApp.dto.TransactionDto;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Transaction;
import com.example.BankingApp.repositories.AccountRepository;
import com.example.BankingApp.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    public void doTransaction(TransactionDto transactionDto) {

        Account account = accountRepository.findByAccountNumber(transactionDto.getAcctNum()).orElseThrow(
                () -> new AccountNotFoundException("Account not found")
        );

      transactionRepository.save(

              Transaction.builder()
                .transAccount(account)
                .transType(transactionDto.getTransType())
                .amount(transactionDto.getTransAmount())
                .build()
        );

    }
}
