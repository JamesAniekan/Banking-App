package com.example.BankingApp.models;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "accounts")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotBlank(message = "Username required")
    private String username;

    @NotBlank(message = "Password required")
    private String password;

    private String firstName;
    private String lastName;

    @NotEmpty(message = "Email required")
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
