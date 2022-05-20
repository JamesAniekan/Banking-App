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
                .address("30 Lafarge Boulevard")
                .state("Bloombell")
                .country("United Lands")
                .build();



        Customer customer = Customer.builder()
                .firstName("Rowland")
                .lastName("Dave")
                .phoneNumber(1115430)
                .email("rowdave@ymail.com")
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void delCus(){
        customerRepository.deleteById(2L);
    }

    @Test
    public void printCustomers(){
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers = " + customers);
    }

}