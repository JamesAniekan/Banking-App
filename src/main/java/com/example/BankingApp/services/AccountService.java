package com.example.BankingApp.services;

import com.example.BankingApp.Exceptions.CustomerNotFoundException;
import com.example.BankingApp.dto.AccountDto;
import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Customer;
import com.example.BankingApp.repositories.AccountRepository;
import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;

    CustomerRepository customerRepository;



    public void createAccount(AccountDto accountDto){

        Customer customer = customerRepository.findByFirstName(accountDto.getCustomerFirstName()).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found")
        );



        Account account = Account.builder()
                .accountNumber(accountDto.getAccountNumber())
                .accountType(accountDto.getAccountType())
                .accountOwner(customer)
                .build();

        accountRepository.save(account);
    }

    public List<AccountResponse> getAccountByCusId(Long cusId){

        List<AccountResponse> accountResponses = new ArrayList<>();

        List<Account> accounts = accountRepository.getAcctByCustomerId(cusId);

        for (Account account: accounts) {
           AccountResponse accountResponse = AccountResponse.builder()
                    .acctId(account.getAccountId())
                    .acctNum(account.getAccountNumber())
                    .acctType(account.getAccountType())
                    .acctBal(account.getAccountBalance())
                    .build();

            accountResponses.add(accountResponse);
        }
        return accountResponses;
    }

}
