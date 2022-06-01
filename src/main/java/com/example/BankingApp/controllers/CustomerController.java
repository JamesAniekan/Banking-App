package com.example.BankingApp.controllers;

import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.dto.LoginRequest;
import com.example.BankingApp.dto.RegisterRequest;
import com.example.BankingApp.models.Customer;
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

//Endpoint to post a customer.
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody RegisterRequest registerRequest){
            customerService.registerCustomer(registerRequest);
            return new ResponseEntity<>("Customer registration successful", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody LoginRequest loginRequest){
        customerService.login(loginRequest);
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }


//Endpoint to get all customers.
    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){

        return status(HttpStatus.OK).body(customerService.getAllCustomers());

    }

    @GetMapping("/getCustomer/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


  @DeleteMapping("customer/{id}")
  public void deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);

  }

  @GetMapping("/customer/{acctNum}")
  public ResponseEntity<CustomerResponse> getCustomerByAcctNum(@PathVariable int acctNum){
        return status(HttpStatus.OK).body(customerService.getCusByAcctNum(acctNum));

  }


}







