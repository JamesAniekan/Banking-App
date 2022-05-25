package com.example.BankingApp.services;

import com.example.BankingApp.Exceptions.AccountNotFoundException;
import com.example.BankingApp.dto.TransactionDto;
import com.example.BankingApp.dto.TransactionResponse;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Transaction;
import com.example.BankingApp.repositories.AccountRepository;
import com.example.BankingApp.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<TransactionResponse> getTransactions(int acctNum) {

        Account account = accountRepository.findByAccountNumber(acctNum).orElseThrow(
                () -> new AccountNotFoundException("Account not found")
        );

        List<Transaction> transactions =  transactionRepository.getTransactionsByAcctNum(account.getAccountId());

        List<TransactionResponse> transactionResponses =  new ArrayList<>();

        for (Transaction transaction: transactions) {
           TransactionResponse transactionResponse = TransactionResponse.builder()
                    .amount(transaction.getAmount())
                    .transType(transaction.getTransType())
                    .id(transaction.getId())
                   .transDate(transaction.getTransDate())
                    .build();
           transactionResponses.add(transactionResponse);
        }
        return transactionResponses;
    }
}
