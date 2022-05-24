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

        //Customer customer = customerRepository.findByFirstName("Otu").get();


        Account account = Account.builder()
                .accountNumber(999993)
                .accountType("saving")
                .accountBalance(9000)
                //.accountOwner(customer)
                .build();

        accountRepository.save(account);

    }

    @Test
    public void printAccounts() {
      List<Account> accounts = accountRepository.getAcctByCustomerId(6L);

        System.out.println("Accounts: " + accounts);

       /* Account account = accountRepository.findByAccountNumber(999993);

        System.out.println("Account : " + account);*/
    }


    @Test
    public void printCus() {
        Customer customer = customerRepository.findByFirstName("Etuk").get();
        System.out.println(customer);
    }
}













