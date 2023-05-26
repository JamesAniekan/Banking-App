package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Customer;
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

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void doTransaction(){

     //Account acct =  accountRepository.findByAccountNumber(444333).get();
        Optional<Customer> customer = customerRepository.findById(1L);

        Optional<Account> acct1 = accountRepository.findById(2L);
//                .accountBalance(8888)
//                .accountType("savngs")
//                .accountNumber(77776666)
//                .accountOwner(customer)
//                .build();

        Transaction transaction = Transaction.builder()
                .transType("Withdrawal")
                .amount(34400)
                .transAccount(acct1.get())
                .build();
            transactionRepository.save(transaction);

    }

    @Test
   public void printTrans(){
        //List<Transaction> transaction
        Transaction trans = transactionRepository.findAll().get(5);
        System.out.println("Transactions = " + trans);
    }

}