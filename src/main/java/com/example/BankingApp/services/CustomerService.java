package com.example.BankingApp.services;


import com.example.BankingApp.Exceptions.AccountNotFoundException;
import com.example.BankingApp.Exceptions.CustomerNotFoundException;
import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.dto.LoginRequest;
import com.example.BankingApp.dto.RegisterRequest;
import com.example.BankingApp.mappings.CustomerMapper;
import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Address;
import com.example.BankingApp.models.Customer;
import com.example.BankingApp.repositories.AccountRepository;
import com.example.BankingApp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;
    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    CustomerMapper customerMapper;

    private final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    public void registerCustomer(RegisterRequest registerRequest){

        Address address = Address.builder()
                .address(registerRequest.getAddress())
                .country(registerRequest.getCountry())
                .state(registerRequest.getState())
                .build();

        Customer customer = Customer.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
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

//             CustomerResponse customerResponse =  customerMapper.cusToCusResponse(customer);
            CustomerResponse customerResponse =  CustomerResponse.builder()
                    .customerId(customer.getCustomerId())
                    .firstName(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .email(customer.getEmail())
                    .phoneNumber(customer.getPhoneNumber())
                    .build();

           customerResponses.add(customerResponse);

        }
        LOG.info("CUSTOMER-RESPONSES " + customerResponses);
    return customerResponses;

    }

    public CustomerResponse getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Customer with id " + id + " not found"));

        return customerMapper.cusToCusResponse(customer);
    }

    public void deleteCustomer(Long id){

        customerRepository.deleteById(id);
    }


    public CustomerResponse getCusByAcctNum(int acctNum) {

       Long cusId = accountRepository.getCustomerIdFromAcctNum(acctNum);

       Customer customer = customerRepository.findById(cusId)
               .orElseThrow(
                       () -> new CustomerNotFoundException("Customer not found")
               );

       return customerMapper.cusToCusResponse(customer);
    }

    public void login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

}

