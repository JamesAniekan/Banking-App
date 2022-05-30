package com.example.BankingApp.models;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"accountOwner" ,"transactionHx"})

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private int accountNumber;
    private String accountType;
    private double accountBalance = 0.0;

    @CreationTimestamp
    private Instant creationDate;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customerId"
    )
    private Customer accountOwner;


    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "transAccount",
            orphanRemoval = true
    )
    private List<Transaction> transactionHx;

}






