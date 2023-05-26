package com.example.BankingApp.repositories;


import com.example.BankingApp.models.Address;
import com.example.BankingApp.models.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void createCustomer(){

        Address address = Address.builder()
                .address("23 Street")
                .state("Ackley")
                .country("United Lands")
                .build();



        Customer customer = Customer.builder()
                .firstName("Ben")
                .lastName("Son")
                .username("Yoo")
                .password("1234")
                .phoneNumber("3335430")
                .email("benson@ymail.com")
                .address(address)
                .build();

        customerRepository.save(customer);
    }

    @Test
    public void delCus(){
        customerRepository.deleteById(3L);
    }

    @Test
    public void printCustomers(){
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers = " + customers);
    }

}