package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void createAccount() {

        Customer customer = customerRepository.findByFirstName("Otu");


        Account account = Account.builder()
                .accountNumber(654333)
                .accountType("Current")
                .accountBalance(20000)
                .accountOwner(customer)
                .build();

        accountRepository.save(account);

    }

    @Test
    public void printAccounts() {
        List<Account> accounts = accountRepository.findAll();

        System.out.println("Accounts = " + accounts);
    }


    @Test
    public void printCus() {
        Customer customer = customerRepository.findByFirstName("Etuk");
        System.out.println(customer);
    }
}













