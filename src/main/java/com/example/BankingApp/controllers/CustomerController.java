package com.example.BankingApp.controllers;

import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.dto.RegisterRequest;
import com.example.BankingApp.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {

  private final CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody RegisterRequest registerRequest){
            customerService.registerCustomer(registerRequest);

            return new ResponseEntity<>("Customer registration successful", HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){

        return status(HttpStatus.OK).body(customerService.getAllCustomers());

    }

}
