package com.payments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gas")
public class Gas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contract_number")
    private int contractNumber;

    @Column(name = "billing_month")
    private String billingMonth;

    @Column(name = "amount_for_consumption")
    private double amountForConsumption;

    @Column(name = "social_number_of_customer")
    private long socialNumber;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
}
