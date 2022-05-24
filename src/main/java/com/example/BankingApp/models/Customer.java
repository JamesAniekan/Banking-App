package com.example.BankingApp.models;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(
            mappedBy = "accountOwner",
            orphanRemoval = true
    )
    private List<Account> accounts;

}
