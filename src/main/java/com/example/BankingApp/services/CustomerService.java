package com.example.BankingApp.services;


import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.dto.RegisterRequest;
import com.example.BankingApp.models.Customer;
import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public void registerCustomer(RegisterRequest registerRequest){

        Customer customer = new Customer();

        customer.setFirstName(registerRequest.getFirstName());
        customer.setLastName(registerRequest.getLastName());
        customer.setEmail(registerRequest.getEmail());
        customer.setPhoneNumber(registerRequest.getPhoneNumber());

        customerRepository.save(customer);

    }

    public List<CustomerResponse> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponse> customerResponses = new ArrayList<>();

        for (Customer customer : customers) {
             CustomerResponse customerResponse =  CustomerResponse.builder()
                                                        .id(customer.getCustomerId())
                                                        .firstName(customer.getFirstName())
                                                        .lastName(customer.getLastName())
                                                        .email(customer.getEmail())
                                                        .phoneNumber(customer.getPhoneNumber())
                                                        .build();

            customerResponses.add(customerResponse);
        }
    return customerResponses;

    }
}
