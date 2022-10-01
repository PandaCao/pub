package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrinkMenuDto {
    String productName;
    Integer unitPrice;
    Boolean isForAdult;
}
