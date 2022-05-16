package com.example.BankingApp.repositories;


import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Address;
import com.example.BankingApp.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void createCustomer(){

        Address address = Address.builder()
                .address("10 Marina lane")
                .state("Lagos")
                .country("Nigeria")
                .build();
//
//        Account account = Account.builder()
//                .accountNumber(7654321)
//                .accountType("savings")
//                .accountBalance(4000)
//                .build();


        Customer customer = Customer.builder()
                .firstName("Effiom")
                .lastName("Ekong")
                .phoneNumber(999443210)
                .email("efimeekg@ymail.com")
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void printCustomers(){
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers = " + customers);
    }

}