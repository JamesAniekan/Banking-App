package com.example.BankingApp.services;

import com.example.BankingApp.Exceptions.CustomerNotFoundException;
import com.example.BankingApp.dto.AccountDto;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Customer;
import com.example.BankingApp.repositories.AccountRepository;
import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;

    CustomerRepository customerRepository;

    public void createAccount(AccountDto accountDto){

        Customer customer = customerRepository.findByFirstName(accountDto.getCustomerName()).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found")
        );

        Account account = Account.builder()
                .accountNumber(accountDto.getAccountNumber())
                .accountType(accountDto.getAccountType())
                .accountOwner(customer)
                .build();

        accountRepository.save(account);
    }

}
