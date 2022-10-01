package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    Integer id;
    String productName;
    Integer amount;
    Integer summaryPrice;
    Boolean isPayed;
}
