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
@Table(name = "water")
public class Water {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "water_id")
    private int id;

    @Column(name = "reporting_month")
    private String reportingMonth;

    @Column(name = "amount_to_pay")
    private double amountToPay;

    @Column(name = "consumption_cbm")
    private int consumptionCubicMetre;

    @Column(name = "social_number_of_customer")
    private long socialNumber;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
}
