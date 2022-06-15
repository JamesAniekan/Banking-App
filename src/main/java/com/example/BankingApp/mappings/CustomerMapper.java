package com.example.BankingApp.mappings;

import com.example.BankingApp.dto.CustomerResponse;
import com.example.BankingApp.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "customerId", source = "customer.customerId")
    CustomerResponse cusToCusResponse(Customer customer);
}
