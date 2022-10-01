package com.example.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="USERS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
    @Column(name="NAME")
    private String name;
    @Column(name="IS_ACTIVE")
    private Boolean isActive;
    @Column(name="BIRTH_DATE")
    private LocalDate birthDate;
    @Column(name="POCKET")
    private Integer pocket;
}
