package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Account;
import com.example.BankingApp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByAccountNumber(int acctNum);

    @Query(
            value = "SELECT * FROM account a where a.customer_id = ?1",
            nativeQuery = true)
    List<Account> getAcctByCustomerId(Long cusId);
}
