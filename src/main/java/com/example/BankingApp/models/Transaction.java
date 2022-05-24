package com.example.BankingApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant transDate;

    private String transType;
    private double amount;

    @ManyToOne(
           cascade =  CascadeType.MERGE,
            fetch =  FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"
    )
    private Account transAccount;
}
