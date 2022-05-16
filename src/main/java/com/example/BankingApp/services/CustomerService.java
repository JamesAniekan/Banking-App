package com.example.BankingApp.services;


import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public void createCustomer(){

    }
}
