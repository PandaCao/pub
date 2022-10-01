package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserListDto {
    Integer id;
    String name;
    Boolean isActive;
    LocalDate birthDate;
    Integer pocket;
}
