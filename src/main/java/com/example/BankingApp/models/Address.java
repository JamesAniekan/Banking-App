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
                column = @Column(name = "cust_address")),
        @AttributeOverride(
                name = "state",
                column = @Column(name = "cust_state")
        ),
        @AttributeOverride(
                name = "country",
                column = @Column(name = "cust_country")
        )
})
public class Address {

    private String address;
    private String state;
    private String country;

}





