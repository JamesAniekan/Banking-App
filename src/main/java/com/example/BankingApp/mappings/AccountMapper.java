package com.example.BankingApp.mappings;

import com.example.BankingApp.dto.AccountResponse;
import com.example.BankingApp.models.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse accountToAccountResponse(Account account);
}
