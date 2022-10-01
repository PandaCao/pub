package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drinkmenu")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrinkMenu {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "product")
    private List<Order> orderList;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="UNIT_PRICE")
    private Integer unitPrice;
    @Column(name="IS_FOR_ADULT")
    private Boolean isForAdult;
}
