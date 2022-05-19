package com.example.BankingApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "address",
                column = @Column(name = "cust_address", nullable = false)),
        @AttributeOverride(
                name = "state",
                column = @Column(name = "cust_state", nullable = false)
        ),
        @AttributeOverride(
                name = "country",
                column = @Column(name = "cust_country", nullable = false)
        )
})
public class Address {

    private String address;
    private String state;
    private String country;

}





