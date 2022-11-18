package com.payments.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "electricity")
public class Electricity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "reporting_month")
    private String reportingMonth;

    @Column(name = "total_sum")
    private Double totalSum;

    @Column(name = "electricity_expense_KWxh")
    private Double electricityExpense;

    @Column(name = "social_number_of_customer")
    private Long socialNumberOfCustomer;

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

}
