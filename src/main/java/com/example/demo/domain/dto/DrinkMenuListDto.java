package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrinkMenuListDto {
    Integer id;
    String productName;
    Integer unitPrice;
    Boolean isForAdult;
}
