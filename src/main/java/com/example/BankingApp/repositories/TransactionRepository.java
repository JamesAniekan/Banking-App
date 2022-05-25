package com.example.BankingApp.repositories;

import com.example.BankingApp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(
           value = "SELECT * FROM transaction t WHERE t.account_id = ?1",
            nativeQuery = true
    )
    List<Transaction> getTransactionsByAcctNum(Long id);
}
