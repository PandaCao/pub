package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SummaryListDto {
    String productName;
    int quantity;
    Integer unityPrice;
    int summaryPrice;
}
