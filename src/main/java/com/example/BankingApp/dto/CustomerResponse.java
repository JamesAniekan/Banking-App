package com.example.BankingApp.dto;

import com.example.BankingApp.models.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}
