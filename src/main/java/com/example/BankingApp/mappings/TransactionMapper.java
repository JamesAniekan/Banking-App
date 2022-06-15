package com.example.BankingApp.mappings;

import com.example.BankingApp.dto.TransactionResponse;
import com.example.BankingApp.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionResponse transToTransResponse(Transaction transaction);
}
