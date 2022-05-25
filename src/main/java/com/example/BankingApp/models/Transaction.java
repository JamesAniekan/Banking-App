package com.example.BankingApp.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "transAccount")
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
            fetch =  FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"
    )
    private Account transAccount;
}
