package com.example.BankingApp.mappings;

import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.models.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse accountToAccountResponse(Account account);
}
