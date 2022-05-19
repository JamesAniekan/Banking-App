package com.example.BankingApp.services;


import com.example.BankingApp.Exceptions.CustomerNotFoundException;
import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.dto.RegisterRequest;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Address;
import com.example.BankingApp.models.Customer;
import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public void registerCustomer(RegisterRequest registerRequest){

        Address address = Address.builder()
                .address(registerRequest.getAddress())
                .country(registerRequest.getCountry())
                .state(registerRequest.getState())
                .build();

        Customer customer = Customer.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .phoneNumber(registerRequest.getPhoneNumber())
                .address(address)
                .build();

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

    public CustomerResponse getCustomerById(Long id) {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(()-> new CustomerNotFoundException("Customer with id " + id + "not found"));


        return CustomerResponse.builder()
                .id(customer.getCustomerId())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .lastName(customer.getLastName())
                .firstName(customer.getFirstName())
                .build();
    }
}
