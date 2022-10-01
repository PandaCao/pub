package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private DrinkMenu product;
    @Column(name="AMOUNT")
    private Integer amount;
    @Column(name="SUMMARY_PRICE")
    private Integer summaryPrice;
    @Column(name="IS_PAYED")
    private Boolean isPayed;
}
