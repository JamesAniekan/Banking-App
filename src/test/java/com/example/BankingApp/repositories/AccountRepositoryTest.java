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
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void createAccount() {

        Customer customer = customerRepository.findByFirstName("Dan").get();


        Account account = Account.builder()
                .accountNumber(2228792)
                .accountType("Current")
                .accountBalance(4200)
                .accountOwner(customer)
                .build();

        accountRepository.save(account);

    }

    @Test
    public void printAccounts() {
      List<Transaction> account = accountRepository.findById(2L).get().getTransactionHx();

        System.out.println("Accounts: " + account);

       /* Account account = accountRepository.findByAccountNumber(999993);

        System.out.println("Account : " + account);*/
    }


    @Test
    public void printCus() {
        Customer customer = customerRepository.findByFirstName("Dan").get();
        System.out.println(customer);
    }

    @Test
    public void printCusId(){
       Optional<Long> customerId = accountRepository.getCustomerIdFromAcctNum(444333);
        System.out.println("Customer ID: " + customerId);
    }
}













