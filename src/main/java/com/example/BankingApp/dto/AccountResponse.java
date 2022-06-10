package com.example.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {
    private Long accountId;
    private int accountNumber;
    private String accountType;
    private double accountBalance;
    private Instant creationDate;
}
