package com.example.BankingApp.models;


import lombok.*;
import org.aspectj.bridge.IMessage;
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
    @NotBlank(message = "Field required")
    private String firstName;
    @NotBlank(message = "field required")
    private String lastName;

    @NotEmpty(message = "Email required")
    private String email;

    @NotEmpty(message = "Phone number required")
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(
            mappedBy = "accountOwner",
            orphanRemoval = true
    )
    private List<Account> accounts;


}
