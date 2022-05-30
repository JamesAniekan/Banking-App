package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstName(String name);

    //Customer getCusByAcctId

}
