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
                .address("30 SpringVille Boulevard")
                .state("Colorado")
                .country("United States")
                .build();



        Customer customer = Customer.builder()
                .firstName("Ramsey")
                .lastName("Acley")
                .phoneNumber(9995430)
                .email("ramackley@ymail.com")
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