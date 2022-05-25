package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void doTransaction(){

     Account acct =  accountRepository.findByAccountNumber(444333).get();

      /*  Account acct = Account.builder()
                .accountBalance(8888)
                .accountType("savngs")
                .accountNumber(77776666)
                .build();*/

        Transaction transaction = Transaction.builder()
                .transType("Payment")
                .amount(67000)
                .transAccount(acct)
                .build();
        transactionRepository.save(transaction);
    }

    @Test
   public void printTrans(){
        List<Transaction> transaction = transactionRepository.findAll();
        System.out.println("Transactions = " + transaction);
    }

}