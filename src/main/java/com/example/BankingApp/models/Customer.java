package com.example.BankingApp.models;


import lombok.*;

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

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "accountOwner",
            fetch = FetchType.EAGER

    )
    private List<Account> accounts;

    @Embedded
    private Address address;

}
